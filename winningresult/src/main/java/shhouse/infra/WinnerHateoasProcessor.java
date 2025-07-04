package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class WinnerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Winner>> {

    @Override
    public EntityModel<Winner> process(EntityModel<Winner> model) {
        return model;
    }
}
