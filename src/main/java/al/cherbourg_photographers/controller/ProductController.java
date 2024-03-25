package al.cherbourg_photographers.controller;

import al.cherbourg_photographers.dto.ProductDTO;
import al.cherbourg_photographers.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping("/searchAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable(name="id") int id) {
        ProductDTO productResponse = productService.updateProduct(productDTO, id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") int id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Le produit a été correctement supprimé", HttpStatus.OK);
    }
}
