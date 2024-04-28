package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.DTO.CreateProductRequestDTO;
import dev.dhanush.EcomProductService.DTO.ProductResponseDTO;
import dev.dhanush.EcomProductService.DTO.fakeStoreDTOs.FakeStoreProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;
import dev.dhanush.EcomProductService.Exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    List<Product> getProducts(double minPrice, double maxPrice);
}
