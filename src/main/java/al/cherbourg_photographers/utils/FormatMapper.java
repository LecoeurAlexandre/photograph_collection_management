package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.FormatDTO;
import al.cherbourg_photographers.entity.FormatEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FormatMapper {
    private final ModelMapper modelMapper;

    public FormatMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public FormatDTO mapToFormatDTO(FormatEntity formatEntity) {
        return modelMapper.map(formatEntity, FormatDTO.class);
    }

    public FormatEntity mapToFormatEntity(FormatDTO formatDTO) {
        return modelMapper.map(formatDTO, FormatEntity.class);
    }
}
