package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class TenantHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Tenant>> {

    @Override
    public EntityModel<Tenant> process(EntityModel<Tenant> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/movein")
                .withRel("movein")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/leave")
                .withRel("leave")
        );

        return model;
    }
}
