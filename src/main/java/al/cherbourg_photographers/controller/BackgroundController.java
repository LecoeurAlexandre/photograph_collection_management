package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.service.WorkshopBackgroundService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/backgrounds")
@RestController
public class BackgroundController {
    @Autowired
    private WorkshopBackgroundService workshopBackgroundService;

    @PostMapping("/save")
    public ResponseEntity<WorkshopBackgroundDTO> createBackground(@Valid @RequestBody WorkshopBackgroundDTO workshopBackgroundDTO) {
        return new ResponseEntity<>(workshopBackgroundService.createBackground(workshopBackgroundDTO), HttpStatus.CREATED);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<WorkshopBackgroundDTO> getBackgroundById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(workshopBackgroundService.getBackgroundById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<WorkshopBackgroundDTO> updateBackground(@Valid @RequestBody WorkshopBackgroundDTO workshopBackgroundDTO, @PathVariable(name="id") int id) {
        WorkshopBackgroundDTO workshopBackgroundResponse = workshopBackgroundService.updateBackground(workshopBackgroundDTO, id);
        return new ResponseEntity<>(workshopBackgroundResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBackground(@PathVariable(name="id") int id) {
        workshopBackgroundService.deleteBackgroundById(id);
        return new ResponseEntity<>("Le fond a été correctement supprimé", HttpStatus.OK);
    }
}
