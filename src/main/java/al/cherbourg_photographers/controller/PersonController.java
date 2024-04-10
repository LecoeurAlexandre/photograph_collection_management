package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PersonDTO;
import al.cherbourg_photographers.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/save")
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.createPerson(personDTO), HttpStatus.CREATED);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable(name= "id") int id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO, @PathVariable(name="id") int id) {
        PersonDTO personResponse = personService.updatePerson(personDTO, id);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name="id") int id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>("La personne a été correctement supprimée", HttpStatus.OK);
    }

}
