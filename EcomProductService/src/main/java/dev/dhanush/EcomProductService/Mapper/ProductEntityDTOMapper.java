package dev.dhanush.EcomProductService.Mapper;

import dev.dhanush.EcomProductService.DTO.ProductResponseDTO;
import dev.dhanush.EcomProductService.Entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageURL(product.getImageURL());
        return responseDTO;
    }
}
