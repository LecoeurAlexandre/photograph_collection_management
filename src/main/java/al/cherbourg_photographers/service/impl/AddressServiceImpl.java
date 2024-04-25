package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.AddressDTO;
import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.AddressEntityRepository;
import al.cherbourg_photographers.service.AddressService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressEntityRepository addressEntityRepository;
    private final GenericMapper<AddressEntity, AddressDTO> mapper;

    public AddressServiceImpl(AddressEntityRepository addressEntityRepository, GenericMapper mapper) {
        this.addressEntityRepository = addressEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        AddressEntity addressEntity = mapper.mapToEntity(addressDTO, AddressEntity.class);
        AddressEntity newAddress = addressEntityRepository.save(addressEntity);
        return mapper.mapToDTO(newAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAddressesByPhotographer() {
        return null;
    }

    @Override
    public AddressDTO getAddressById(int id) {
        AddressEntity addressEntity = getAddressByIdInDB(id);
        return mapper.mapToDTO(addressEntity, AddressDTO.class);
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO, int id) {
        AddressEntity addressEntity = getAddressByIdInDB(id);
        addressEntity.setStreetNumber(addressDTO.getStreetNumber());
        addressEntity.setStreetName(addressDTO.getStreetName());
        addressEntity.setCityName(addressDTO.getCityName());
        AddressEntity updatedAddress = addressEntityRepository.save(addressEntity);
        return mapper.mapToDTO(updatedAddress, AddressDTO.class);
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
