package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.PersonDTO;
import al.cherbourg_photographers.entity.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    private final ModelMapper modelMapper;

    public PersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public PersonDTO mapToPersonDTO(PersonEntity personEntity) {
        return modelMapper.map(personEntity, PersonDTO.class);
    }

    public PersonEntity mapToPersonEntity(PersonDTO personDTO) {
        return modelMapper.map(personDTO, PersonEntity.class);
    }
}
