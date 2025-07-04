package shhouse.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shhouse.domain.*;

@Component
public class HouseSupplyHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<HouseSupply>> {

    @Override
    public EntityModel<HouseSupply> process(EntityModel<HouseSupply> model) {
        return model;
    }
}
