package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.ViewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewEntityRepository extends CrudRepository<ViewEntity, Integer> {
}
