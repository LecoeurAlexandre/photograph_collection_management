package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PhotographDTO;
import al.cherbourg_photographers.service.PhotographService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photographs")
public class PhotographController {
    private final PhotographService photographService;

    public PhotographController(PhotographService photographService) {
        this.photographService = photographService;
    }
    @PostMapping("/save")
    public ResponseEntity<PhotographDTO> createPhotograph(@Valid @RequestBody PhotographDTO photographDTO) {
        return new ResponseEntity<>(photographService.createPhotograph(photographDTO), HttpStatus.CREATED);
    }
}
