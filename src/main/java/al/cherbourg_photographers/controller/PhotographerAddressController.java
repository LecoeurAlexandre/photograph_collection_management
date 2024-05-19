package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.PhotographerAddressDTOReq;
import al.cherbourg_photographers.dto.PhotographerAddressDTORes;
import al.cherbourg_photographers.service.PhotographerAddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/photographerAddress")
public class PhotographerAddressController {
    private final PhotographerAddressService photographerAddressService;

    public PhotographerAddressController(PhotographerAddressService photographerAddressService) {
        this.photographerAddressService = photographerAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<PhotographerAddressDTORes> createPhotographerAddress(@Valid @RequestBody PhotographerAddressDTOReq photographerAddressDTOReq) {
        return new ResponseEntity<>(photographerAddressService.createPhotographerAddress(photographerAddressDTOReq), HttpStatus.CREATED);
    }
}
