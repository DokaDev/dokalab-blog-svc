package com.dokalab.blog.category.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Data
public class CategoryDto {
    private Long categoryId;
    private String categoryName;

    @JsonManagedReference
    private List<CategoryDto> subCategories;

    @JsonBackReference
    private CategoryDto parentCategory;
}
