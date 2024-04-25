package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.FurnitureDTO;
import al.cherbourg_photographers.entity.FurnitureEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.FurnitureEntityRepository;
import al.cherbourg_photographers.service.FurnitureService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureEntityRepository furnitureEntityRepository;
    private final GenericMapper<FurnitureEntity, FurnitureDTO> mapper;

    public FurnitureServiceImpl(FurnitureEntityRepository furnitureEntityRepository, GenericMapper mapper) {
        this.furnitureEntityRepository = furnitureEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public FurnitureDTO createFurniture(FurnitureDTO furnitureDTO) {
        FurnitureEntity newFurniture = furnitureEntityRepository.save((FurnitureEntity) mapper.mapToEntity(furnitureDTO, FurnitureEntity.class));
        return mapper.mapToDTO(newFurniture, FurnitureDTO.class);
    }

    @Override
    public List<FurnitureDTO> getFurnituresByPhotographerAndAddress() {
        return null;
    }

    @Override
    public FurnitureDTO getFurnitureById(int id) {
        FurnitureEntity furnitureEntity = getFurnitureByIdInDB(id);
        return mapper.mapToDTO(furnitureEntity, FurnitureDTO.class);
    }

    @Override
    public FurnitureDTO updateFurniture(FurnitureDTO furnitureDTO, int id) {
        FurnitureEntity furnitureEntity = getFurnitureByIdInDB(id);
        furnitureEntity.setFurnitureName(furnitureDTO.getFurnitureName());
        furnitureEntity.setFurnitureDescription(furnitureDTO.getFurnitureDescription());
        FurnitureEntity updateFurniture = furnitureEntityRepository.save(furnitureEntity);
        return mapper.mapToDTO(updateFurniture, FurnitureDTO.class);
    }

    @Override
    public void deleteFurnitureById(int id) {
        FurnitureEntity furnitureEntity = getFurnitureByIdInDB(id);
        furnitureEntityRepository.deleteById(furnitureEntity.getId());
    }

    private FurnitureEntity getFurnitureByIdInDB(int id) {
        return furnitureEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Furniture", "id", id));
    }
}
