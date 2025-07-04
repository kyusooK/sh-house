package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class MaintenanceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Maintenance>> {

    @Override
    public EntityModel<Maintenance> process(EntityModel<Maintenance> model) {
        return model;
    }
}
