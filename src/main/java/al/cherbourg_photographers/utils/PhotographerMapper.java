package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.entity.PhotographerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhotographerMapper {
    private final ModelMapper modelMapper;

    public PhotographerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PhotographerDTO mapToDTO(PhotographerEntity photographerEntity) {
        return modelMapper.map(photographerEntity, PhotographerDTO.class);
    }

    public PhotographerEntity mapToEntity(PhotographerDTO photographerDTO) {
        return modelMapper.map(photographerDTO, PhotographerEntity.class);
    }
}