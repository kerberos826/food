package food.domain;

import food.StoreApplication;
import food.domain.OrderDeclined;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String menu;

    private String adress;

    private Integer qty;

    private String option;

    private String orderid;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderDeclined orderDeclined = new OrderDeclined(this);
        orderDeclined.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptOrDecline(AcceptOrDeclineCommand acceptOrDeclineCommand) {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void startCooking() {
        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();
    }

    public void finishCooking() {
        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();
    }

    public static void loadOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
