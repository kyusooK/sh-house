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
    AnnouncementRepository announcementRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SupplyPlanApproved'"
    )
    public void wheneverSupplyPlanApproved_RegisterAnnouncement(
        @Payload SupplyPlanApproved supplyPlanApproved
    ) {
        SupplyPlanApproved event = supplyPlanApproved;
        System.out.println(
            "\n\n##### listener RegisterAnnouncement : " +
            supplyPlanApproved +
            "\n\n"
        );

        // Sample Logic //
        Announcement.registerAnnouncement(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
