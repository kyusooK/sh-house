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
    TenantRepository tenantRepository;

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Contracted'"
    )
    public void wheneverContracted_RegisterTenant(
        @Payload Contracted contracted
    ) {
        Contracted event = contracted;
        System.out.println(
            "\n\n##### listener RegisterTenant : " + contracted + "\n\n"
        );

        // Sample Logic //
        Tenant.registerTenant(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Left'"
    )
    public void wheneverLeft_ApplyMaintenance(@Payload Left left) {
        Left event = left;
        System.out.println(
            "\n\n##### listener ApplyMaintenance : " + left + "\n\n"
        );

        // Sample Logic //
        Maintenance.applyMaintenance(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ExtendApproved'"
    )
    public void wheneverExtendApproved_UpdateMoveIn(
        @Payload ExtendApproved extendApproved
    ) {
        ExtendApproved event = extendApproved;
        System.out.println(
            "\n\n##### listener UpdateMoveIn : " + extendApproved + "\n\n"
        );

        // Sample Logic //
        Tenant.updateMoveIn(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
