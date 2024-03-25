package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
}
