package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.entity.FormatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatEntityRepository extends CrudRepository<FormatEntity, Integer> {
    boolean existsByFormatName(String formatName);
    boolean existsByFormatSize(String formatSize);
}
