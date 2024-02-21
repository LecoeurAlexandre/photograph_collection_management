package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.FormatDTO;
import al.cherbourg_photographers.service.FormatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
