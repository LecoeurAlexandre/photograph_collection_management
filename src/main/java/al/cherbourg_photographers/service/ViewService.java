package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.ViewDTO;

import java.util.List;

public interface ViewService {
    ViewDTO createView(ViewDTO viewDTO);
    List<ViewDTO> getAllViews();
    ViewDTO getViewById(int id);
    ViewDTO updateView(ViewDTO viewDTO, int id);
    void deleteViewById(int id);
}
