package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingFinished extends AbstractEvent {

    private Long id;
    private String orderid;

    public CookingFinished(Cooking aggregate) {
        super(aggregate);
    }

    public CookingFinished() {
        super();
    }
}
