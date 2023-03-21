package food.domain;

import food.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String menu;
    private String adress;
    private Integer qty;
}
