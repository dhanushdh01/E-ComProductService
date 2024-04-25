package dev.dhanush.EcomProductService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    @OneToMany
    Product List<Product> products;
}
