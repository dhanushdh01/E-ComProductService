package dev.dhanush.EcomProductService.DTO;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> products;
}
