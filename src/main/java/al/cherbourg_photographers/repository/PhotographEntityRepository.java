package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.PhotographEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographEntityRepository extends CrudRepository<PhotographEntity, Long> {
}
