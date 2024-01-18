package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkshopBackgroundMapper {
    public static WorkshopBackgroundDTO mapToWorkshopBackgroundDTO(WorkshopBackgroundEntity workshopBackgroundEntity) {
        return new WorkshopBackgroundDTO(
                workshopBackgroundEntity.getId(),
                workshopBackgroundEntity.getBackgroundDescription()
        );
    }

    public static WorkshopBackgroundEntity mapToWorkshopBackgroundEntity(WorkshopBackgroundDTO workshopBackgroundDTO) {
        return new WorkshopBackgroundEntity(
                workshopBackgroundDTO.getId(),
                workshopBackgroundDTO.getBackgroundDescription()
        );
    }
}
