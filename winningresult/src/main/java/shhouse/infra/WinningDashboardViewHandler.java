package shhouse.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shhouse.config.kafka.KafkaProcessor;
import shhouse.domain.*;

@Service
public class WinningDashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private WinningDashboardRepository winningDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSubscriptionDrawn_then_CREATE_1(
        @Payload SubscriptionDrawn subscriptionDrawn
    ) {
        try {
            if (!subscriptionDrawn.validate()) return;

            // view 객체 생성
            WinningDashboard winningDashboard = new WinningDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            winningDashboard.setName(subscriptionDrawn.getApplyName());
            winningDashboard.setPhoneNumber(subscriptionDrawn.getPhoneNumber());
            winningDashboard.setEmail(subscriptionDrawn.getEmail());
            winningDashboard.setHouse(subscriptionDrawn.getHouse());
            winningDashboard.setLocation(subscriptionDrawn.getLocation());
            // view 레파지 토리에 save
            winningDashboardRepository.save(winningDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
