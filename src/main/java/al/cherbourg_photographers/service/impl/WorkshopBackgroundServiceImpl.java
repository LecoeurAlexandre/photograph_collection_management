package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.WorkshopBackgroundEntityRepository;
import al.cherbourg_photographers.service.WorkshopBackgroundService;
import al.cherbourg_photographers.utils.WorkshopBackgroundMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopBackgroundServiceImpl implements WorkshopBackgroundService {
    private final WorkshopBackgroundEntityRepository workshopBackgroundEntityRepository;
    private final WorkshopBackgroundMapper mapper;

    public WorkshopBackgroundServiceImpl(WorkshopBackgroundEntityRepository workshopBackgroundEntityRepository, WorkshopBackgroundMapper mapper) {
        this.workshopBackgroundEntityRepository = workshopBackgroundEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public WorkshopBackgroundDTO createBackground(WorkshopBackgroundDTO workshopBackgroundDTO) {
        WorkshopBackgroundEntity workshopBackgroundEntity = mapper.mapToWorkshopBackgroundEntity(workshopBackgroundDTO);
        WorkshopBackgroundEntity newBackground = workshopBackgroundEntityRepository.save(workshopBackgroundEntity);
        WorkshopBackgroundDTO backgroundResponse = mapper.mapToWorkshopBackgroundDTO(newBackground);
        return backgroundResponse;
    }

    @Override
    public List<WorkshopBackgroundDTO> getBackgroundsByPhotographerAndAddress() {
        return null;
    }

    @Override
    public WorkshopBackgroundDTO getBackgroundById(int id) {
        WorkshopBackgroundEntity workshopBackgroundEntity = getWorkshopBackgroundByIdInDB(id);
        return mapper.mapToWorkshopBackgroundDTO(workshopBackgroundEntity);
    }

    @Override
    public WorkshopBackgroundDTO updateBackground(WorkshopBackgroundDTO workshopBackgroundDTO, int id) {
        WorkshopBackgroundEntity workshopBackgroundEntity = getWorkshopBackgroundByIdInDB(id);
        workshopBackgroundEntity.setBackgroundDescription(workshopBackgroundDTO.getBackgroundDescription());
        WorkshopBackgroundEntity updateBackground = workshopBackgroundEntityRepository.save(workshopBackgroundEntity);
        return mapper.mapToWorkshopBackgroundDTO(updateBackground);
    }

    @Override
    public void deleteBackgroundById(int id) {
        WorkshopBackgroundEntity workshopBackgroundEntity = getWorkshopBackgroundByIdInDB(id);
        workshopBackgroundEntityRepository.deleteById(workshopBackgroundEntity.getId());
    }
    private WorkshopBackgroundEntity getWorkshopBackgroundByIdInDB(int id) {
        return workshopBackgroundEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Background", "id", id));
    }
}
