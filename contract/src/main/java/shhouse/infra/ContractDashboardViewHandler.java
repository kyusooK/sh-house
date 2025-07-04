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
public class ContractDashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ContractDashboardRepository contractDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenContracted_then_CREATE_1(@Payload Contracted contracted) {
        try {
            if (!contracted.validate()) return;

            // view 객체 생성
            ContractDashboard contractDashboard = new ContractDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            contractDashboard.setTitle(contracted.getTitle());
            contractDashboard.setContractStartAt(contracted.getContractAt());
            contractDashboard.setContractEndAt(contracted.getContractEndAt());
            contractDashboard.setName(contracted.getName());
            contractDashboard.setHouseName(contracted.getHouseName());
            contractDashboard.setHouseLocation(contracted.getHouseLocation());
            // view 레파지 토리에 save
            contractDashboardRepository.save(contractDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
