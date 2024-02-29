package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.FurnitureDTO;

import java.util.List;

public interface FurnitureService {
    FurnitureDTO createFurniture(FurnitureDTO furnitureDTO);
    List<FurnitureDTO> getFurnituresByPhotographerAndAddress();
    FurnitureDTO getFurnitureById(int id);
    FurnitureDTO updateFurniture(FurnitureDTO furnitureDTO, int id);
    void deleteFurnitureById(int id);
}
