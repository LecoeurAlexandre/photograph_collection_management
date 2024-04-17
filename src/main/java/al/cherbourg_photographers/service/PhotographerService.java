package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.PhotographerDTO;

import java.util.List;

public interface PhotographerService {
    PhotographerDTO createPhotographer(PhotographerDTO photographerDTO);
    List<PhotographerDTO> getAllPhotographers();
    PhotographerDTO getPhotographerById(int id);
    PhotographerDTO updatePhotographer(PhotographerDTO photographerDTO, int id);
    void deletePhotographerById(int id);
}
