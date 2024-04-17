package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.service.PhotographerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
