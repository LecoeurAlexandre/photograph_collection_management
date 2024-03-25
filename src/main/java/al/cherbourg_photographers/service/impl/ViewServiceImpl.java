package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.ViewDTO;
import al.cherbourg_photographers.entity.ViewEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.ViewEntityRepository;
import al.cherbourg_photographers.service.ViewService;
import al.cherbourg_photographers.utils.ViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewServiceImpl implements ViewService {
    private final ViewEntityRepository viewEntityRepository;
    private final ViewMapper mapper;

    public ViewServiceImpl(ViewEntityRepository viewEntityRepository, ViewMapper mapper) {
        this.viewEntityRepository = viewEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public ViewDTO createView(ViewDTO viewDTO) {
        ViewEntity newView = viewEntityRepository.save(mapper.mapToViewEntity(viewDTO));
        return mapper.mapToViewDTO(newView);
    }

    @Override
    public List<ViewDTO> getAllViews() {
        List<ViewEntity> views = (List<ViewEntity>) viewEntityRepository.findAll();
        List<ViewDTO> viewsDTOList = views.stream().map(view->mapper.mapToViewDTO(view)).collect(Collectors.toList());
        return viewsDTOList;
    }

    @Override
    public ViewDTO getViewById(int id) {
        ViewEntity viewEntity = getViewByIdInDB(id);
        return mapper.mapToViewDTO(viewEntity);
    }

    @Override
    public ViewDTO updateView(ViewDTO viewDTO, int id) {
        ViewEntity viewEntity = getViewByIdInDB(id);
        viewEntity.setMonumentName(viewDTO.getMonumentName());
        ViewEntity updateView = viewEntityRepository.save(viewEntity);
        return mapper.mapToViewDTO(updateView);
    }

    @Override
    public void deleteViewById(int id) {
        ViewEntity viewEntity = getViewByIdInDB(id);
        viewEntityRepository.deleteById(viewEntity.getId());
    }
    private ViewEntity getViewByIdInDB(int id) {
        return viewEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("View", "id", id));
    }
}
