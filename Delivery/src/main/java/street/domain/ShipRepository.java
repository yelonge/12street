package street.domain;

import street.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="ships", path="ships")
public interface ShipRepository extends PagingAndSortingRepository<Ship, Long>{

}
