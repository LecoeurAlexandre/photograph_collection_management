package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.FormatDTO;

import java.util.List;

public interface FormatService {
    FormatDTO createFormat(FormatDTO formatDTO);
    List<FormatDTO> getAllFormats();
    FormatDTO getFormatById(int id);
    FormatDTO updateFormat(FormatDTO formatDTO, int id);
    void deleteFormatById(int id);
}
