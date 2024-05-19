package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.PhotographerAddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerAddressEntityRepository extends CrudRepository<PhotographerAddressEntity, Integer> {

}
