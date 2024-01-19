package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WorkshopBackgroundMapper {
    private final ModelMapper modelMapper;

    public WorkshopBackgroundMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WorkshopBackgroundDTO mapToWorkshopBackgroundDTO(WorkshopBackgroundEntity workshopBackgroundEntity) {
        return modelMapper.map(workshopBackgroundEntity, WorkshopBackgroundDTO.class);
    }

    public WorkshopBackgroundEntity mapToWorkshopBackgroundEntity(WorkshopBackgroundDTO workshopBackgroundDTO) {
        return modelMapper.map(workshopBackgroundDTO, WorkshopBackgroundEntity.class);
    }
}
