package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.service.PhotographerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerController {
    private final PhotographerService photographerService;

    public PhotographerController(PhotographerService photographerService) {
        this.photographerService = photographerService;
    }

    @PostMapping("/save")
    public ResponseEntity<PhotographerDTO> createPhotographer(@Valid @RequestBody PhotographerDTO photographerDTO) {
        return new ResponseEntity<>(photographerService.createPhotographer(photographerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<PhotographerDTO>> getAllPhotographers() {
        return ResponseEntity.ok(photographerService.getAllPhotographers());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity getPersonById(@PathVariable(name= "id") int id) {
        return ResponseEntity.ok(photographerService.getPhotographerById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PhotographerDTO> updatePhotographer(@Valid @RequestBody PhotographerDTO photographerDTO, @PathVariable(name="id") int id) {
        PhotographerDTO photographerResponse = photographerService.updatePhotographer(photographerDTO, id);
        return new ResponseEntity<>(photographerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name="id") int id) {
        photographerService.deletePhotographerById(id);
        return new ResponseEntity<>("Le photographe a été correctement supprimé", HttpStatus.OK);
    }
}
