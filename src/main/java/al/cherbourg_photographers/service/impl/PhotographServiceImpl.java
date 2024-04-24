package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.PhotographDTO;
import al.cherbourg_photographers.entity.PhotographEntity;
import al.cherbourg_photographers.repository.PhotographEntityRepository;
import al.cherbourg_photographers.service.PhotographService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotographServiceImpl implements PhotographService {
    private final PhotographEntityRepository photographEntityRepository;
    private final GenericMapper<PhotographEntity, PhotographDTO> mapper;

    public PhotographServiceImpl(PhotographEntityRepository photographEntityRepository, GenericMapper<PhotographEntity, PhotographDTO> mapper) {
        this.photographEntityRepository = photographEntityRepository;
        this.mapper = mapper;
    }


    @Override
    public PhotographDTO createPhotograph(PhotographDTO photographDTO) {
        PhotographEntity newPhotograph = mapper.mapToEntity(photographDTO, PhotographEntity.class);
        PhotographEntity savedPhotograph = photographEntityRepository.save(newPhotograph);
        return mapper.mapToDTO(savedPhotograph, PhotographDTO.class);
    }

    @Override
    public List<PhotographDTO> getLast10Photographs() {
        return null;
    }

    @Override
    public List<PhotographDTO> getPhotographsByPhotographer(int photographerId) {
        return null;
    }

    @Override
    public PhotographDTO getPhotographById(int id) {
        return null;
    }

    @Override
    public PhotographDTO updatePhotograph(PhotographDTO photographDTO, int id) {
        return null;
    }

    @Override
    public void deletePhotographById(int id) {

    }
}
