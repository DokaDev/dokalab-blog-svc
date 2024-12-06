package com.dokalab.blog.category;

import com.dokalab.blog.category.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> findAllCategories();
    List<Category> findSubCategoriesByParentCategoryId(Long categoryId);
    Category findCategoryByCategoryId(Long categoryId);
}
