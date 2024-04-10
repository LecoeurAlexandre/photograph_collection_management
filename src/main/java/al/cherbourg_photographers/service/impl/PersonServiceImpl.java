package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.PersonDTO;
import al.cherbourg_photographers.entity.PersonEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.PersonEntityRepository;
import al.cherbourg_photographers.service.PersonService;
import al.cherbourg_photographers.utils.PersonMapper;
import al.cherbourg_photographers.utils.StringHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonEntityRepository personEntityRepository;
    private final PersonMapper mapper;

    public PersonServiceImpl(PersonEntityRepository personEntityRepository, PersonMapper mapper) {
        this.personEntityRepository = personEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        personDTO.setLastname(StringHandler.capitalizeFirstLetters(personDTO.getLastname()));
        personDTO.setFirstname(StringHandler.capitalizeFirstLetters(personDTO.getFirstname()));
        personDTO.setBirthPlace(StringHandler.capitalizeFirstLetters(personDTO.getBirthPlace()));
        personDTO.setDeathPlace(StringHandler.capitalizeFirstLetters(personDTO.getDeathPlace()));
        personDTO.setDeathPlace(StringHandler.capitalizeFirstLetters(personDTO.getDeathPlace()));
        PersonEntity newPerson = personEntityRepository.save(mapper.mapToPersonEntity(personDTO));
        return mapper.mapToPersonDTO(newPerson);
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        List<PersonEntity> persons = (List<PersonEntity>) personEntityRepository.findAll();
        List<PersonDTO> personsDTOList = persons.stream().map(person->mapper.mapToPersonDTO(person)).collect(Collectors.toList());
        return personsDTOList;
    }

    @Override
    public PersonDTO getPersonById(int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        return mapper.mapToPersonDTO(personEntity);
    }

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO, int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        personEntity.setGender(personDTO.isGender());
        personEntity.setLastname(StringHandler.capitalizeFirstLetters(personDTO.getLastname()));
        personEntity.setFirstname(StringHandler.capitalizeFirstLetters(personDTO.getFirstname()));
        personEntity.setBirthdate(personDTO.getBirthdate());
        personEntity.setDeathdate(personDTO.getDeathdate());
        personEntity.setBirthPlace(StringHandler.capitalizeFirstLetters(personDTO.getBirthPlace()));
        personEntity.setDeathPlace(StringHandler.capitalizeFirstLetters(personDTO.getDeathPlace()));
        personEntity.setJob(personDTO.getJob());
        PersonEntity updatedPerson = personEntityRepository.save(personEntity);
        return mapper.mapToPersonDTO(updatedPerson);
    }

    @Override
    public void deletePersonById(int id) {
        PersonEntity personEntity = getPersonByIdInDB(id);
        personEntityRepository.deleteById(personEntity.getId());
    }

    private PersonEntity getPersonByIdInDB(int id) {
        return personEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }
}