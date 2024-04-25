package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.Client.FakeStoreClient;
import dev.dhanush.EcomProductService.DTO.fakeStoreDTOs.FakeStoreProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;
import dev.dhanush.EcomProductService.Exception.NoProductPresentException;
import dev.dhanush.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl{

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No products are found");
        }
        return fakeStoreProducts;
    }

    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null){
            throw new ProductNotFoundException("Product not found with id : " + productId);
        }
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }
}
