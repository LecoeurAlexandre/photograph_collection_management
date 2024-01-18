package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;
import al.cherbourg_photographers.entity.WorkshopBackgroundEntity;
import al.cherbourg_photographers.repository.WorkshopBackgroundEntityRepository;
import al.cherbourg_photographers.service.WorkshopBackgroundService;
import al.cherbourg_photographers.utils.WorkshopBackgroundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopBackgroundServiceImpl implements WorkshopBackgroundService {
    @Autowired
    private WorkshopBackgroundEntityRepository workshopBackgroundEntityRepository;
    @Autowired
    private WorkshopBackgroundMapper mapper;

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
        return null;
    }

    @Override
    public WorkshopBackgroundDTO updateBackground(WorkshopBackgroundDTO workshopBackgroundDTO, int id) {
        return null;
    }

    @Override
    public void deleteBackgroundById(int id) {

    }
}
