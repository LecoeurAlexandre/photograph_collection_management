package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.PhotographDTO;

import java.util.List;

public interface PhotographService {
    PhotographDTO createPhotograph(PhotographDTO photographDTO);
    List<PhotographDTO> getLast10Photographs();
    List<PhotographDTO> getPhotographsByPhotographer(int photographerId);
    PhotographDTO getPhotographById(int id);
    PhotographDTO updatePhotograph(PhotographDTO photographDTO, int id);
    void deletePhotographById(int id);

}
