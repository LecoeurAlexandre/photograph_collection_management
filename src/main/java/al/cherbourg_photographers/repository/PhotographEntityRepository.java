package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.PhotographEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographEntityRepository extends CrudRepository<PhotographEntity, Integer> {
    List<PhotographEntity> findTop10ByOrderByCreationDateDesc();
}
