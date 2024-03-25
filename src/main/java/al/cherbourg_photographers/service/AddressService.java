package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO);
    List<AddressDTO> getAddressesByPhotographer();
    AddressDTO getAddressById(int id);
    AddressDTO updateAddress(AddressDTO addressDTO, int id);
    void deleteAddressById(int id);
}
