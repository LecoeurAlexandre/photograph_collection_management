package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.PhotographerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerEntityRepository extends CrudRepository<PhotographerEntity, Integer> {
}
