package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FrontEndHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FrontEnd>> {

    @Override
    public EntityModel<FrontEnd> process(EntityModel<FrontEnd> model) {
        return model;
    }
}
