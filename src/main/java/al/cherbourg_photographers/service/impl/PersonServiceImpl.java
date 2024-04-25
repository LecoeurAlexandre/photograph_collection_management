package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.PersonDTO;
import al.cherbourg_photographers.entity.PersonEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.PersonEntityRepository;
import al.cherbourg_photographers.service.PersonService;
import al.cherbourg_photographers.utils.GenericMapper;
import al.cherbourg_photographers.utils.StringHandler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonEntityRepository personEntityRepository;
    private final GenericMapper<PersonEntity, PersonDTO> mapper;

    public PersonServiceImpl(PersonEntityRepository personEntityRepository, GenericMapper mapper) {
        this.personEntityRepository = personEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        capitalizePersonAttributes(personDTO);

        PersonEntity newPerson = mapper.mapToEntity(personDTO, PersonEntity.class);
        newPerson.setCreationDate(LocalDateTime.now());

        PersonEntity savedPerson = personEntityRepository.save(newPerson);
        return mapper.mapToDTO(savedPerson, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        List<PersonEntity> persons = (List<PersonEntity>) personEntityRepository.findAll();
        List<PersonDTO> personsDTOList = persons.stream().map(person-> mapper.mapToDTO(person, PersonDTO.class)).collect(Collectors.toList());
        return personsDTOList;
    }

    @Override
    public PersonDTO getPersonById(int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        return mapper.mapToDTO(personEntity, PersonDTO.class);
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO, int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        personEntity.setGender(personDTO.isGender());
        capitalizePersonAttributes(personDTO);
        personEntity.setLastname(personDTO.getLastname());
        personEntity.setMaidenName(personDTO.getMaidenName());
        personEntity.setFirstname(personDTO.getFirstname());
        personEntity.setBirthPlace(personDTO.getBirthPlace());
        personEntity.setDeathPlace(personDTO.getDeathPlace());
        personEntity.setBirthdate(personDTO.getBirthdate());
        personEntity.setDeathdate(personDTO.getDeathdate());
        personEntity.setJob(personDTO.getJob());
        personEntity.setUpdateDate(LocalDateTime.now());
        PersonEntity updatedPerson = personEntityRepository.save(personEntity);
        return mapper.mapToDTO(updatedPerson, PersonDTO.class);
    }

    @Override
    public void deletePersonById(int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        personEntityRepository.deleteById(personEntity.getId());
    }

    private PersonEntity getPersonByIdInDB(int id) {
        return personEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }

    private PersonDTO capitalizePersonAttributes(PersonDTO personDTO) {
        personDTO.setLastname(StringHandler.capitalizeFirstLetters(personDTO.getLastname()));
        personDTO.setFirstname(StringHandler.capitalizeFirstLetters(personDTO.getFirstname()));
        personDTO.setMaidenName(StringHandler.capitalizeFirstLetters(personDTO.getMaidenName()));
        personDTO.setBirthPlace(StringHandler.capitalizeFirstLetters(personDTO.getBirthPlace()));
        personDTO.setDeathPlace(StringHandler.capitalizeFirstLetters(personDTO.getDeathPlace()));
        personDTO.setJob(StringHandler.capitalizeOnlyOneFirstLetter(personDTO.getJob()));
        return personDTO;
    }
}
