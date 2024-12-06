package com.dokalab.blog.category;

import com.dokalab.blog.category.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllParentCategories() {
        List<CategoryDto> allParentCategories = categoryService.getCategoryHierarchy();
        System.out.println(allParentCategories);
        System.out.println(allParentCategories.size());

        assertThat(allParentCategories).isNotNull();
    }

    @Test
    void getCategoryInfoAsResponseModel() {
        var res = categoryService.getCategoryInfoAsResponseModel();
//        System.out.println(res);
        for (ResponseCategoryInfo re : res) {
            System.out.println(re);
        }
        System.out.println(res.size());
    }
}