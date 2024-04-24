package al.cherbourg_photographers.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GenericMapper <Entity, DTO> {
    private final ModelMapper modelMapper;

    public GenericMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DTO mapToDTO(Entity entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
    public Entity mapToEntity(DTO dto, Class<Entity> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
