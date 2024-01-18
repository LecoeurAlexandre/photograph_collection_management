package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopBackgroundEntityRepository extends CrudRepository<WorkshopBackgroundEntity, Integer> {
}
