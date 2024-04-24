package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PhotographDTO;
import al.cherbourg_photographers.service.PhotographService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/search10")
    public ResponseEntity<List<PhotographDTO>> getLast10Photographs() {
        return ResponseEntity.ok(photographService.getLast10Photographs());
    }
}
