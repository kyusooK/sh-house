package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class HousingProjectHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<HousingProject>> {

    @Override
    public EntityModel<HousingProject> process(
        EntityModel<HousingProject> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/processcompletion"
                )
                .withRel("processcompletion")
        );

        return model;
    }
}
