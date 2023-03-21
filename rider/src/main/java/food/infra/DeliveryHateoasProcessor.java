package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Delivery>> {

    @Override
    public EntityModel<Delivery> process(EntityModel<Delivery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pickorder")
                .withRel("pickorder")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/confirmdelivery"
                )
                .withRel("confirmdelivery")
        );

        return model;
    }
}
