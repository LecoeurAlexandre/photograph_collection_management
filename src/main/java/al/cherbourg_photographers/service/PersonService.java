package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(PersonDTO personDTO);
    List<PersonDTO> getAllPersons();
    PersonDTO getPersonById(int id);
    PersonDTO updatePerson(PersonDTO personDTO, int id);
    void deletePersonById(int id);
}
