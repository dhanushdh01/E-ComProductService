package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.DTO.CreateProductRequestDTO;
import dev.dhanush.EcomProductService.DTO.ProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Category;
import dev.dhanush.EcomProductService.Entity.Product;
import dev.dhanush.EcomProductService.Exception.CategoryNotFoundException;
import dev.dhanush.EcomProductService.Exception.ProductNotFoundException;
import dev.dhanush.EcomProductService.Mapper.ProductEntityDTOMapper;
import dev.dhanush.EcomProductService.Repository.CategoryRepository;
import dev.dhanush.EcomProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product product : savedProducts){
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {
        /*
        // basic code to implement null check
        Product savedProduct = productRepository.findById(productId).get();
        if(savedProduct == null){
            throw new ProductNotFoundException("Product not found for id : " + productId);
        }
        return savedProduct;
         */
        Product product =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for id : " + productId)
        );
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id : " + productRequestDTO.getCategoryId()));
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        List<Product> categoryProducts = savedCategory.getProducts();
        categoryProducts.add(product);
        savedCategory.setProducts(categoryProducts);
        categoryRepository.save(savedCategory);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    // cant update category and rating for a product
    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for id : " + productId));
        savedProduct.setTitle(createProductRequestDTO.getTitle());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());
        savedProduct.setPrice(createProductRequestDTO.getPrice());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
        savedProduct = productRepository.save(savedProduct); // save works as upsert, which is insert and update
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(
                productRepository.findProductByTitle(productName)
        );
    }


    //TODO: convert product list to product response dto list
    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}