package food.domain;

import food.FrontApplication;
import food.domain.UserNoticed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FrontEnd_table")
@Data
public class FrontEnd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String menu;

    private String status;

    private String orderid;

    @PostPersist
    public void onPostPersist() {
        UserNoticed userNoticed = new UserNoticed(this);
        userNoticed.publishAfterCommit();
    }

    public static FrontEndRepository repository() {
        FrontEndRepository frontEndRepository = FrontApplication.applicationContext.getBean(
            FrontEndRepository.class
        );
        return frontEndRepository;
    }

    public static void loadStatusChange(StatusUpdated statusUpdated) {
        /** Example 1:  new item 
        FrontEnd frontEnd = new FrontEnd();
        repository().save(frontEnd);

        UserNoticed userNoticed = new UserNoticed(frontEnd);
        userNoticed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(statusUpdated.get???()).ifPresent(frontEnd->{
            
            frontEnd // do something
            repository().save(frontEnd);

            UserNoticed userNoticed = new UserNoticed(frontEnd);
            userNoticed.publishAfterCommit();

         });
        */

    }
}
