package dev.dhanush.EcomProductService.Service;

import dev.dhanush.EcomProductService.DTO.CategoryResponseDTO;
import dev.dhanush.EcomProductService.DTO.CreateCategoryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategory(UUID categoryId){
        return null;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories(){
        return List.of();
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO){
        return null;
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO ,UUID categoryId){
        return null;
    }

    @Override
    public boolean deleteCategory (UUID categoryId){
        return false;
    }
}
