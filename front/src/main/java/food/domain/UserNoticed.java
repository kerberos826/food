package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UserNoticed extends AbstractEvent {

    private Long id;

    public UserNoticed(FrontEnd aggregate) {
        super(aggregate);
    }

    public UserNoticed() {
        super();
    }
}
