package dev.dhanush.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private FakeStoreProductRatingDTO rating;
}
