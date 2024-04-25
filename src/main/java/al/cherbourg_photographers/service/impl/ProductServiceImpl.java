package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.ProductDTO;
import al.cherbourg_photographers.entity.ProductEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.ProductEntityRepository;
import al.cherbourg_photographers.service.ProductService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductEntityRepository productEntityRepository;
    private final GenericMapper<ProductEntity, ProductDTO> mapper;

    public ProductServiceImpl(ProductEntityRepository productEntityRepository, GenericMapper<ProductEntity, ProductDTO> mapper) {
        this.productEntityRepository = productEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        productDTO.setProductName(StringUtils.capitalize(productDTO.getProductName()));
        ProductEntity newProduct = productEntityRepository.save(mapper.mapToEntity(productDTO, ProductEntity.class));
        return mapper.mapToDTO(newProduct, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = (List<ProductEntity>) productEntityRepository.findAll();
        List<ProductDTO> productsDTOList = products.stream().map(product->mapper.mapToDTO(product, ProductDTO.class)).collect(Collectors.toList());
        return productsDTOList;
    }

    @Override
    public ProductDTO getProductById(int id) {
        ProductEntity productEntity = getProductByIdInDB(id);
        return mapper.mapToDTO(productEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, int id) {
        productDTO.setProductName(StringUtils.capitalize(productDTO.getProductName()));
        ProductEntity productEntity = getProductByIdInDB(id);
        productEntity.setProductName(productDTO.getProductName());
        ProductEntity updatedProduct = productEntityRepository.save(productEntity);
        return mapper.mapToDTO(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProductById(int id) {
        ProductEntity productEntity = getProductByIdInDB(id);
        productEntityRepository.deleteById(productEntity.getId());
    }

    private ProductEntity getProductByIdInDB(int id) {
        return productEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }
}
