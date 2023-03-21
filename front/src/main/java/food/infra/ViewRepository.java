package food.infra;

import food.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "views", path = "views")
public interface ViewRepository extends PagingAndSortingRepository<View, Long> {
    List<View> findByOrderid(String orderid);
}
