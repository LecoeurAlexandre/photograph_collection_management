package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.FurnitureDTO;
import al.cherbourg_photographers.service.FormatService;
import al.cherbourg_photographers.service.FurnitureService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/furnitures")
@RestController
public class FurnitureController {
    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/save")
    public ResponseEntity<FurnitureDTO> createFurniture(@Valid @RequestBody FurnitureDTO furnitureDTO) {
        return new ResponseEntity<>(furnitureService.createFurniture(furnitureDTO), HttpStatus.CREATED);
    }
}
