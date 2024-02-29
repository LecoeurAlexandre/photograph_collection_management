package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.FurnitureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureEntityRepository extends CrudRepository<FurnitureEntity, Integer> {
}
