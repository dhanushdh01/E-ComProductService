package dev.dhanush.EcomProductService.Controller;

import dev.dhanush.EcomProductService.DTO.CreateProductRequestDTO;
import dev.dhanush.EcomProductService.DTO.ProductResponseDTO;
import dev.dhanush.EcomProductService.Exception.InvalidInputException;
import dev.dhanush.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product") // base URL for all the APIs in this controller
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService; //field injection

    // to get all products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // to get a specific product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        return ResponseEntity.ok(productService.getProduct(id));
    }

    //to create a product
    @PostMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    // to update the product (which is already created)
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));
    }

    // to delete a product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    // to get a product by name
    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable("productName") String productName){
        return ResponseEntity.ok(productService.getProduct(productName));
    }

    // to get a product by given range
    @GetMapping("/{min}/{max}")
    public ResponseEntity<ProductResponseDTO> getProductByPriceRange(@PathVariable("min") double minPrice, @PathVariable("max") double maxPrice){
        return ResponseEntity.ok(productService.getProduct(minPrice,maxPrice));
    }
}
