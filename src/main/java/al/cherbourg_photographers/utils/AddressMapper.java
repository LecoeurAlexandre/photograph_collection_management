package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.AddressDTO;
import al.cherbourg_photographers.entity.AddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    private final ModelMapper modelMapper;

    public AddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AddressDTO mapToAddressDTO(AddressEntity addressEntity) {
        return modelMapper.map(addressEntity, AddressDTO.class);
    }
    public AddressEntity mapToAddressEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, AddressEntity.class);
    }
}
