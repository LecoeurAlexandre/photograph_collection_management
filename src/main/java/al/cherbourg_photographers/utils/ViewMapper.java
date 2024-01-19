package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.ViewDTO;
import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.ViewEntity;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ViewMapper {
    private final ModelMapper modelMapper;

    public ViewMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ViewDTO mapToViewDTO(ViewEntity viewEntity) {
        return modelMapper.map(viewEntity, ViewDTO.class);
    }

    public ViewEntity mapToViewEntity(ViewDTO viewDTO) {
        return modelMapper.map(viewDTO, ViewEntity.class);
    }
}
