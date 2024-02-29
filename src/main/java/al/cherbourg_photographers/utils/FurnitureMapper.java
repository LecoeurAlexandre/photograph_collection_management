package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.FurnitureDTO;
import al.cherbourg_photographers.entity.FurnitureEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FurnitureMapper {
    private final ModelMapper modelMapper;

    public FurnitureMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public FurnitureDTO mapToFurnitureDTO(FurnitureEntity furnitureEntity) {
        return modelMapper.map(furnitureEntity, FurnitureDTO.class);
    }

    public FurnitureEntity mapToFurnitureEntity(FurnitureDTO furnitureDTO) {
        return modelMapper.map(furnitureDTO, FurnitureEntity.class);
    }
}
