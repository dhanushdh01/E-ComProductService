package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;
import dev.dhanush.EcomProductService.Exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(int productId);
}
