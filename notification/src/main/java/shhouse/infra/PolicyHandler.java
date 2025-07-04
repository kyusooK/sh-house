package shhouse.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shhouse.config.kafka.KafkaProcessor;
import shhouse.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscriptionDisApproved'"
    )
    public void wheneverSubscriptionDisApproved_NotifySubscriptionResult(
        @Payload SubscriptionDisApproved subscriptionDisApproved
    ) {
        SubscriptionDisApproved event = subscriptionDisApproved;
        System.out.println(
            "\n\n##### listener NotifySubscriptionResult : " +
            subscriptionDisApproved +
            "\n\n"
        );

        // Sample Logic //
        Notification.notifySubscriptionResult(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscriptionDrawn'"
    )
    public void wheneverSubscriptionDrawn_NotifyWinning(
        @Payload SubscriptionDrawn subscriptionDrawn
    ) {
        SubscriptionDrawn event = subscriptionDrawn;
        System.out.println(
            "\n\n##### listener NotifyWinning : " + subscriptionDrawn + "\n\n"
        );

        // Sample Logic //
        Notification.notifyWinning(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TenantRegistered'"
    )
    public void wheneverTenantRegistered_NotifyMoveIn(
        @Payload TenantRegistered tenantRegistered
    ) {
        TenantRegistered event = tenantRegistered;
        System.out.println(
            "\n\n##### listener NotifyMoveIn : " + tenantRegistered + "\n\n"
        );

        // Sample Logic //
        Notification.notifyMoveIn(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ExtendApproved'"
    )
    public void wheneverExtendApproved_NotifyExtendResult(
        @Payload ExtendApproved extendApproved
    ) {
        ExtendApproved event = extendApproved;
        System.out.println(
            "\n\n##### listener NotifyExtendResult : " + extendApproved + "\n\n"
        );

        // Sample Logic //
        Notification.notifyExtendResult(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ExtendDisApproved'"
    )
    public void wheneverExtendDisApproved_NotifyExtendResult(
        @Payload ExtendDisApproved extendDisApproved
    ) {
        ExtendDisApproved event = extendDisApproved;
        System.out.println(
            "\n\n##### listener NotifyExtendResult : " +
            extendDisApproved +
            "\n\n"
        );

        // Sample Logic //
        Notification.notifyExtendResult(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
