package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String orderid;

    public OrderAccepted(Cooking aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
