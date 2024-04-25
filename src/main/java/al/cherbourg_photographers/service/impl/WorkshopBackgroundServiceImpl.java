package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.WorkshopBackgroundEntityRepository;
import al.cherbourg_photographers.service.WorkshopBackgroundService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopBackgroundServiceImpl implements WorkshopBackgroundService {
    private final WorkshopBackgroundEntityRepository workshopBackgroundEntityRepository;
    private final GenericMapper<WorkshopBackgroundEntity, WorkshopBackgroundDTO> mapper;

    public WorkshopBackgroundServiceImpl(WorkshopBackgroundEntityRepository workshopBackgroundEntityRepository, GenericMapper<WorkshopBackgroundEntity, WorkshopBackgroundDTO> mapper) {
        this.workshopBackgroundEntityRepository = workshopBackgroundEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public WorkshopBackgroundDTO createBackground(WorkshopBackgroundDTO workshopBackgroundDTO) {
        WorkshopBackgroundEntity workshopBackgroundEntity = mapper.mapToEntity(workshopBackgroundDTO, WorkshopBackgroundEntity.class);
        WorkshopBackgroundEntity newBackground = workshopBackgroundEntityRepository.save(workshopBackgroundEntity);
        WorkshopBackgroundDTO backgroundResponse = mapper.mapToDTO(newBackground, WorkshopBackgroundDTO.class);
        return backgroundResponse;
    }

    @Override
    public List<WorkshopBackgroundDTO> getBackgroundsByPhotographerAndAddress() {
        return null;
    }

    @Override
    public WorkshopBackgroundDTO getBackgroundById(int id) {
        WorkshopBackgroundEntity workshopBackgroundEntity = getWorkshopBackgroundByIdInDB(id);
        return mapper.mapToDTO(workshopBackgroundEntity, WorkshopBackgroundDTO.class);
    }

    @Override
    public WorkshopBackgroundDTO updateBackground(WorkshopBackgroundDTO workshopBackgroundDTO, int id) {
        WorkshopBackgroundEntity workshopBackgroundEntity = getWorkshopBackgroundByIdInDB(id);
        workshopBackgroundEntity.setBackgroundDescription(workshopBackgroundDTO.getBackgroundDescription());
        WorkshopBackgroundEntity updateBackground = workshopBackgroundEntityRepository.save(workshopBackgroundEntity);
        return mapper.mapToDTO(updateBackground, WorkshopBackgroundDTO.class);
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
