package dev.dhanush.EcomProductService.Repository;

import dev.dhanush.EcomProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String title);
    Product findFirstProductByTitle(String title);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
