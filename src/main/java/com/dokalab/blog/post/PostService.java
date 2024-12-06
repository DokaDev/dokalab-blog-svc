package com.dokalab.blog.post;

import com.dokalab.blog.category.CategoryMapper;
import com.dokalab.blog.category.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final CategoryMapper categoryMapper;

    public List<Category> getAllCategories() {
        return categoryMapper.findAllCategories();
    }

    public List<Category> getSubCategoriesByParentCategoryId(Long categoryId) {
        return categoryMapper.findSubCategoriesByParentCategoryId(categoryId);
    }

    public Category getCategoryByCategoryId(Long categoryId) {
        return categoryMapper.findCategoryByCategoryId(categoryId);
    }
}
