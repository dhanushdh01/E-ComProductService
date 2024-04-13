package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.Client.FakeStoreClient;
import dev.dhanush.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
