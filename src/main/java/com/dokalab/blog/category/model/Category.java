package com.dokalab.blog.category.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Data
public class Category {
    private Long categoryId;
    private String categoryName;

//    @ToString.Exclude
    @JsonManagedReference
    private List<Category> subCategories;

//    @ToString.Exclude
//    @JsonBackReference
//    private Category parentCategory;
}
