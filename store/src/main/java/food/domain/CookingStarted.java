package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private String orderid;

    public CookingStarted(Cooking aggregate) {
        super(aggregate);
    }

    public CookingStarted() {
        super();
    }
}
