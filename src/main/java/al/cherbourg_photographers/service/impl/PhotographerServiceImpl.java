package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.PersonDTO;
import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.entity.PhotographerEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.PhotographerEntityRepository;
import al.cherbourg_photographers.service.PersonService;
import al.cherbourg_photographers.service.PhotographerService;
import al.cherbourg_photographers.utils.PersonMapper;
import al.cherbourg_photographers.utils.PhotographerMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PhotographerServiceImpl implements PhotographerService {
    private final PhotographerEntityRepository photographerEntityRepository;
    private final PhotographerMapper photographerMapper;
    private final PersonMapper personMapper;
    private final PersonService personService;

    public PhotographerServiceImpl(PhotographerEntityRepository photographerEntityRepository, PhotographerMapper photographerMapper, PersonMapper personMapper, PersonService personService) {
        this.photographerEntityRepository = photographerEntityRepository;
        this.photographerMapper = photographerMapper;
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @Override
    public PhotographerDTO createPhotographer(PhotographerDTO photographerDTO) {
        PhotographerEntity newPhotographerEntity = photographerMapper.mapToEntity(photographerDTO);
        newPhotographerEntity.setCreationDate(LocalDateTime.now());
        PhotographerEntity savedPhotographer = photographerEntityRepository.save(newPhotographerEntity);
        return photographerMapper.mapToDTO(savedPhotographer);
    }

    @Override
    public List<PhotographerDTO> getAllPhotographers() {
        List<PhotographerEntity> photographers = (List<PhotographerEntity>) photographerEntityRepository.findAll();
        return photographers.stream()
                .map(photographerEntity -> {
                    PersonDTO personDTO = personService.getPersonById(photographerEntity.getId());
                    if (personDTO != null) {
                        return new PhotographerDTO(
                                personDTO.getId(),
                                personDTO.isGender(),
                                personDTO.getLastname(),
                                personDTO.getMaidenName(),
                                personDTO.getFirstname(),
                                personDTO.getBirthdate(),
                                personDTO.getDeathdate(),
                                personDTO.getBirthPlace(),
                                personDTO.getDeathPlace(),
                                personDTO.getJob(),
                                photographerEntity.getStartDate(),
                                photographerEntity.getEndDate()
                        );
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull) // Filtrer les résultats null
                .collect(Collectors.toList());
    }

    @Override
    public PhotographerDTO getPhotographerById(int id) {
        PersonDTO personDTO = personService.getPersonById(id);
        PhotographerEntity photographerEntity = getPhotographerByIdInDB(id);
        return new PhotographerDTO(
                personDTO.getId(),
                personDTO.isGender(),
                personDTO.getLastname(),
                personDTO.getMaidenName(),
                personDTO.getFirstname(),
                personDTO.getBirthdate(),
                personDTO.getDeathdate(),
                personDTO.getBirthPlace(),
                personDTO.getDeathPlace(),
                personDTO.getJob(),
                photographerEntity.getStartDate(),
                photographerEntity.getEndDate());
    }

    @Override
    public PhotographerDTO updatePhotographer(PhotographerDTO photographerDTO, int id) {
        PersonDTO updatedPerson = personService.updatePerson(personMapper.mapToPersonDTO(photographerDTO), id);
        PhotographerEntity photographerEntity = getPhotographerByIdInDB(id);
        photographerEntity.setStartDate(photographerDTO.getStartDate());
        photographerEntity.setEndDate(photographerDTO.getEndDate());
        photographerEntity.setUpdateDate(LocalDateTime.now());
        PhotographerEntity updatedPhotographer = photographerEntityRepository.save(photographerEntity);
        return new PhotographerDTO(updatedPerson.getId(),
                updatedPerson.isGender(),
                updatedPerson.getLastname(),
                updatedPerson.getMaidenName(),
                updatedPerson.getFirstname(),
                updatedPerson.getBirthdate(),
                updatedPerson.getDeathdate(),
                updatedPerson.getBirthPlace(),
                updatedPerson.getDeathPlace(),
                updatedPerson.getJob(),
                updatedPhotographer.getStartDate(),
                updatedPhotographer.getEndDate());
    }

    @Override
    public void deletePhotographerById(int id) {
        PhotographerEntity photographerEntity = getPhotographerByIdInDB(id);
        photographerEntityRepository.deleteById(photographerEntity.getId());
    }

    private PhotographerEntity getPhotographerByIdInDB(int id) {
        return photographerEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Photographer", "id", id));
    }
}
