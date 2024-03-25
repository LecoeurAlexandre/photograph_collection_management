package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(int id);
    ProductDTO updateProduct(ProductDTO productDTO, int id);
    void deleteProductById(int id);
}
