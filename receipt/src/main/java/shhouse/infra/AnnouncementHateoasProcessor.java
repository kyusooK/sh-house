package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class AnnouncementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Announcement>> {

    @Override
    public EntityModel<Announcement> process(EntityModel<Announcement> model) {
        return model;
    }
}
