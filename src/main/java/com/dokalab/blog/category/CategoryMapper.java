package com.dokalab.blog.category;

import com.dokalab.blog.category.model.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryDto> getCategoryHierarchy();
    // List<CategoryDto> findAllCategories();
    // List<CategoryDto> findSubCategoriesByParentCategoryId(Long categoryId);
    // CategoryDto findCategoryByCategoryId(Long categoryId);
}
