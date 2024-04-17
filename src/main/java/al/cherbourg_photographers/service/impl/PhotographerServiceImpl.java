package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.entity.PersonEntity;
import al.cherbourg_photographers.entity.PhotographerEntity;
import al.cherbourg_photographers.repository.PersonEntityRepository;
import al.cherbourg_photographers.repository.PhotographerEntityRepository;
import al.cherbourg_photographers.service.PersonService;
import al.cherbourg_photographers.service.PhotographerService;
import al.cherbourg_photographers.utils.PersonMapper;
import al.cherbourg_photographers.utils.PhotographerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotographerServiceImpl implements PhotographerService {
    private final PhotographerEntityRepository photographerEntityRepository;
    private final PhotographerMapper photographerMapper;
    private final PersonMapper personMapper;
    private final PersonEntityRepository personEntityRepository;
    public PhotographerServiceImpl(PhotographerEntityRepository photographerEntityRepository, PhotographerMapper mapper, PersonService personService, PhotographerMapper photographerMapper, PersonMapper personMapper, PersonEntityRepository personEntityRepository) {
        this.photographerEntityRepository = photographerEntityRepository;
        this.photographerMapper = photographerMapper;
        this.personMapper = personMapper;
        this.personEntityRepository = personEntityRepository;
    }

    @Override
    public PhotographerDTO createPhotographer(PhotographerDTO photographerDTO) {
        PersonEntity personEntity = personEntityRepository.save(personMapper.mapToPersonEntity(photographerDTO));
        photographerDTO.setId(personEntity.getId());
        PhotographerEntity newPhotographerEntity = photographerEntityRepository.save(photographerMapper.mapToEntity(photographerDTO));
        return new PhotographerDTO(personEntity.getId(), personEntity.isGender(), personEntity.getLastname(), personEntity.getMaidenName(), personEntity.getFirstname(), personEntity.getBirthdate(), personEntity.getDeathdate(), personEntity.getBirthPlace(), personEntity.getDeathPlace(), personEntity.getJob(), newPhotographerEntity.getStartDate(), newPhotographerEntity.getEndDate());
    }

    @Override
    public List<PhotographerDTO> getAllPhotographers() {
        return null;
    }

    @Override
    public PhotographerDTO getPhotographerById(int id) {
        return null;
    }

    @Override
    public PhotographerDTO updatePhotographer(PhotographerDTO photographerDTO, int id) {
        return null;
    }

    @Override
    public void deletePhotographerById(int id) {

    }
}
