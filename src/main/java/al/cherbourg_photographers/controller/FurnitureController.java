package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.FurnitureDTO;
import al.cherbourg_photographers.service.FurnitureService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/search/{id}")
    public ResponseEntity<FurnitureDTO> getFurnitureById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(furnitureService.getFurnitureById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FurnitureDTO> updateFurniture(@Valid @RequestBody FurnitureDTO furnitureDTO, @PathVariable(name="id") int id) {
        FurnitureDTO furnitureResponse = furnitureService.updateFurniture(furnitureDTO, id);
        return new ResponseEntity<>(furnitureResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable(name="id") int id) {
        furnitureService.deleteFurnitureById(id);
        return new ResponseEntity<>("Le mobilier a été correctement supprimé.", HttpStatus.OK);
    }
}
