package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends CrudRepository<PersonEntity, Integer> {
}
