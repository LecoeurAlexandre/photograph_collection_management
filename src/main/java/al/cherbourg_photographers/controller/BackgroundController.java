package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.service.WorkshopBackgroundService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/backgrounds")
@RestController
public class BackgroundController {
    @Autowired
    private WorkshopBackgroundService workshopBackgroundService;

    @PostMapping("/save")
    public ResponseEntity<WorkshopBackgroundDTO> createBackground(@Valid @RequestBody WorkshopBackgroundDTO workshopBackgroundDTO) {
        return new ResponseEntity<>(workshopBackgroundService.createBackground(workshopBackgroundDTO), HttpStatus.CREATED);
    }

}
