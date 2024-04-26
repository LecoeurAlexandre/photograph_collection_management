package al.cherbourg_photographers.repository;

import al.cherbourg_photographers.dto.PhotographerAddressDTORes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerAddressEntityRepository extends CrudRepository<PhotographerAddressDTORes, Integer> {

}
