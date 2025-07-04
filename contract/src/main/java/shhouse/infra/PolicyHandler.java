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
    ContractRepository contractRepository;

    @Autowired
    ExtendContractRepository extendContractRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscriptionDrawn'"
    )
    public void wheneverSubscriptionDrawn_RegisterContract(
        @Payload SubscriptionDrawn subscriptionDrawn
    ) {
        SubscriptionDrawn event = subscriptionDrawn;
        System.out.println(
            "\n\n##### listener RegisterContract : " +
            subscriptionDrawn +
            "\n\n"
        );

        // Sample Logic //
        Contract.registerContract(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Left'"
    )
    public void wheneverLeft_EndContract(@Payload Left left) {
        Left event = left;
        System.out.println("\n\n##### listener EndContract : " + left + "\n\n");

        // Sample Logic //
        Contract.endContract(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
