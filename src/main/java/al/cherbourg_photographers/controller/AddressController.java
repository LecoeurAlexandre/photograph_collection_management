package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.AddressDTO;
import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/addresses")
@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        return new ResponseEntity<>(addressService.createAddress(addressDTO), HttpStatus.CREATED);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(name="id") int id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@Valid @RequestBody AddressDTO addressDTO, @PathVariable(name="id") int id) {
        AddressDTO addressResponse = addressService.updateAddress(addressDTO, id);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(name="id") int id) {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>("L'adresse a été correctement supprimée.", HttpStatus.OK);
    }
}
