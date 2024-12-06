package com.dokalab.blog.category;

import com.dokalab.blog.category.model.*;
import com.dokalab.blog.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final PostMapper postMapper;

    public List<CategoryDto> getCategoryHierarchy() {
        return categoryMapper.getCategoryHierarchy();
    }

    public List<ResponseCategoryInfo> getCategoryInfoAsResponseModel() {
        List<CategoryDto> categoryHierarchy = getCategoryHierarchy();
        return convertToResponseModel(categoryHierarchy);
    }

    private List<ResponseCategoryInfo> convertToResponseModel(List<CategoryDto> categories) {
        List<ResponseCategoryInfo> result = new ArrayList<>();
        
        for (CategoryDto category : categories) {
            ResponseCategoryInfo responseInfo = new ResponseCategoryInfo(category);
            responseInfo.setPostCount(postMapper.getPostCountByCategoryId(category.getCategoryId()));
            result.add(responseInfo);
            
            if (category.getSubCategories() != null && !category.getSubCategories().isEmpty()) {
                result.addAll(convertToResponseModel(category.getSubCategories()));
            }
        }
        
        return result;
    }
}
