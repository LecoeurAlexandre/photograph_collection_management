package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.ViewDTO;
import al.cherbourg_photographers.service.ViewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/views")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @PostMapping("/save")
    public ResponseEntity<ViewDTO> createView(@Valid @RequestBody ViewDTO viewDTO) {
        return new ResponseEntity<>(viewService.createView(viewDTO), HttpStatus.CREATED);
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<ViewDTO>> getAllViews() {
        return ResponseEntity.ok(viewService.getAllViews());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<ViewDTO> getViewById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(viewService.getViewById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ViewDTO> updateView(@Valid @RequestBody ViewDTO viewDTO, @PathVariable(name="id") int id) {
        ViewDTO viewResponse = viewService.updateView(viewDTO, id);
        return new ResponseEntity<>(viewResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBackground(@PathVariable(name="id") int id) {
        viewService.deleteViewById(id);
        return new ResponseEntity<>("La vue a été correctement supprimée", HttpStatus.OK);
    }
}
