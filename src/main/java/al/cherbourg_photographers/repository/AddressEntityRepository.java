package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends CrudRepository <AddressEntity, Integer> {
}
