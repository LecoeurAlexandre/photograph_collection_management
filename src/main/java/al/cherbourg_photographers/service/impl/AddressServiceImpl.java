package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.AddressDTO;
import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.AddressEntityRepository;
import al.cherbourg_photographers.service.AddressService;
import al.cherbourg_photographers.utils.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressEntityRepository addressEntityRepository;
    private final AddressMapper mapper;

    public AddressServiceImpl(AddressEntityRepository addressEntityRepository, AddressMapper mapper) {
        this.addressEntityRepository = addressEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        AddressEntity newAddress = addressEntityRepository.save(mapper.mapToAddressEntity(addressDTO));
        return mapper.mapToAddressDTO(newAddress);
    }

    @Override
    public List<AddressDTO> getAddressesByPhotographer() {
        return null;
    }

    @Override
    public AddressDTO getAddressById(int id) {
        AddressEntity addressEntity = getAddressByIdInDB(id);
        return mapper.mapToAddressDTO(addressEntity);
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO, int id) {
        AddressEntity addressEntity = getAddressByIdInDB(id);
        addressEntity.setStreetNumber(addressDTO.getStreetNumber());
        addressEntity.setStreetName(addressDTO.getStreetName());
        addressEntity.setCityName(addressDTO.getCityName());
        AddressEntity updatedAddress = addressEntityRepository.save(addressEntity);
        return mapper.mapToAddressDTO(updatedAddress);
    }

    @Override
    public void deleteAddressById(int id) {
        AddressEntity addressEntity = getAddressByIdInDB(id);
        addressEntityRepository.deleteById(addressEntity.getId());
    }
    private AddressEntity getAddressByIdInDB(int id) {
        return addressEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
    }
}
