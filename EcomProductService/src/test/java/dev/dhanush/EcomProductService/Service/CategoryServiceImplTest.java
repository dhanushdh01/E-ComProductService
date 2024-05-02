package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.Entity.Category;
import dev.dhanush.EcomProductService.Entity.Product;
import dev.dhanush.EcomProductService.Exception.CategoryNotFoundException;
import dev.dhanush.EcomProductService.Repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {
    @Mock // @Mock for all dependencies
    private CategoryRepository categoryRepository;

    @InjectMocks // @InjectMocks for the class under test
    private CategoryServiceImpl categoryService;

    @BeforeEach // @BeforeEach for setup
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks and inject them ,adds all the required mocks.
        // (not required nowadays).
    }

    // This method will return the total price of all the products in the category.
    // Test methods are always public void methods.
    @Test
    public void testGetTotalPriceForMultipleProductsUnderCategory(){
        //Arrange - setup the data
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedTotalCost = 300.00;

        //Act - perform the operation
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);

        //Assert - all the checks
        Assertions.assertEquals(actualTotalCost, expectedTotalCost);
    }

    @Test
    public void testGetTotalPriceForZeroProductsUnderCategory(){
        //Arrange -> setup the data
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockDataWithZeroProducts();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedTotalCost = 0.0;

        //Act -> perform the operation
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);

        //Assert -> all the checks
        Assertions.assertEquals(actualTotalCost, expectedTotalCost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testCategoryNotFoundExceptionThrown(){
        //Arrange -> setup the data
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        //Act and Assert -> check if the exception is thrown
        Assertions.assertThrows(CategoryNotFoundException.class,
                () -> categoryService.getTotalPriceForCategory(categoryId));
    }

    private Optional<Category> getCategoryMockDataWithZeroProducts(){
        //Arrange -> setup the data
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        //Act -> perform the operation
        List<Product> products = new ArrayList<>();

        //Assert -> all the checks
        category.setProducts(products);
        return Optional.of(category);
    }

    private Optional<Category> getCategoryMockData(){
        //Arrange -> setup the data
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.00);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(200.00);
        product2.setCategory(category);

        //Act -> perform the operation
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        //Assert -> all the checks
        category.setProducts(products);
        return Optional.of(category);
    }

}