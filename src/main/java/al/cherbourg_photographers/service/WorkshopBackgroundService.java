package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.WorkshopBackgroundDTO;

import java.util.List;

public interface WorkshopBackgroundService {
    WorkshopBackgroundDTO createBackground(WorkshopBackgroundDTO workshopBackgroundDTO);
    List<WorkshopBackgroundDTO> getBackgroundsByPhotographerAndAddress();
    WorkshopBackgroundDTO getBackgroundById(int id);
    WorkshopBackgroundDTO updateBackground(WorkshopBackgroundDTO workshopBackgroundDTO, int id);
    void deleteBackgroundById(int id);
}
