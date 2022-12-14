package street.infra;

import street.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="statuses", path="statuses")
public interface StatusRepository extends PagingAndSortingRepository<Status, Long> {

    List<Status> findByItemId(String itemId);
List<Status> findByOrderId(String orderId);


    
}
