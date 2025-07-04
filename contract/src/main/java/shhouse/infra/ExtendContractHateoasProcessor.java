package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class ExtendContractHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ExtendContract>> {

    @Override
    public EntityModel<ExtendContract> process(
        EntityModel<ExtendContract> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/checkcontract")
                .withRel("checkcontract")
        );

        return model;
    }
}
