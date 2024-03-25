package al.cherbourg_photographers.utils;

import al.cherbourg_photographers.dto.ProductDTO;
import al.cherbourg_photographers.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO mapToProductDTO(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDTO.class);
    }
    public ProductEntity mapToProductEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }
}
