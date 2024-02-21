package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.FormatDTO;
import al.cherbourg_photographers.service.FormatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/format")
public class FormatController {
    private final FormatService formatService;
    @Autowired
    public FormatController(FormatService formatService) {
        this.formatService = formatService;
    }
    @PostMapping("/save")
    public ResponseEntity<FormatDTO> createFormat (@Valid @RequestBody FormatDTO formatDTO) {
        return new ResponseEntity<>(formatService.createFormat(formatDTO), HttpStatus.CREATED);
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<FormatDTO>> getAllFormats() {
        return ResponseEntity.ok(formatService.getAllFormats());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<FormatDTO> getFormatById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(formatService.getFormatById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FormatDTO> updateFormat(@Valid @RequestBody FormatDTO formatDTO, @PathVariable(name="id") int id) {
        FormatDTO formatResponse = formatService.updateFormat(formatDTO, id);
        return new ResponseEntity<>(formatResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFormat(@PathVariable(name="id") int id) {
        formatService.deleteFormatById(id);
        return new ResponseEntity<>("Le format a été correctement supprimé", HttpStatus.OK);
    }

}
