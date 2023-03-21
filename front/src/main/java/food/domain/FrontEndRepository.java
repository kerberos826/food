package food.domain;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "frontEnds", path = "frontEnds")
public interface FrontEndRepository
    extends PagingAndSortingRepository<FrontEnd, Long> {}
