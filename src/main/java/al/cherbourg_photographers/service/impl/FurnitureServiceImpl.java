package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.FurnitureDTO;
import al.cherbourg_photographers.entity.FurnitureEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.FurnitureEntityRepository;
import al.cherbourg_photographers.service.FurnitureService;
import al.cherbourg_photographers.utils.FurnitureMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureEntityRepository furnitureEntityRepository;
    private final FurnitureMapper mapper;

    public FurnitureServiceImpl(FurnitureEntityRepository furnitureEntityRepository, FurnitureMapper mapper) {
        this.furnitureEntityRepository = furnitureEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public FurnitureDTO createFurniture(FurnitureDTO furnitureDTO) {
        FurnitureEntity newFurniture = furnitureEntityRepository.save(mapper.mapToFurnitureEntity(furnitureDTO));
        return mapper.mapToFurnitureDTO(newFurniture);
    }

    @Override
    public List<FurnitureDTO> getFurnituresByPhotographerAndAddress() {
        return null;
    }

    @Override
    public FurnitureDTO getFurnitureById(int id) {
        FurnitureEntity furnitureEntity = getFurnitureByIdInDB(id);
        return mapper.mapToFurnitureDTO(furnitureEntity);
    }

    @Override
    public FurnitureDTO updateFurniture(FurnitureDTO furnitureDTO, int id) {
        FurnitureEntity furnitureEntity = getFurnitureByIdInDB(id);
        furnitureEntity.setFurnitureName(furnitureDTO.getFurnitureName());
        furnitureEntity.setFurnitureDescription(furnitureDTO.getFurnitureDescription());
        FurnitureEntity updateFurniture = furnitureEntityRepository.save(furnitureEntity);
        return mapper.mapToFurnitureDTO(updateFurniture);
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
