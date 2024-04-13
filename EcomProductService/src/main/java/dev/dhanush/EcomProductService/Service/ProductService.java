package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(int productId);
}
