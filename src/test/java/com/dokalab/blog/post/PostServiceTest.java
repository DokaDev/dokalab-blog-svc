package com.dokalab.blog.post;

import com.dokalab.blog.category.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    void getAllCategories() {
        List<Category> allCategories = postService.getAllCategories();
//        System.out.println(allCategories);
        for (Category allCategory : allCategories) {
            System.out.println(allCategory);
        }
        System.out.println(allCategories.size());

        assertThat(allCategories).isNotNull();
    }

    @Test
    void getSubCategoriesByParentCategoryId() {
        Long categoryId = 1L;

        List<Category> subCategories = postService.getSubCategoriesByParentCategoryId(categoryId);
//        System.out.println(subCategories);
        for (Category subCategory : subCategories) {
            System.out.println(subCategory);
        }
        System.out.println(subCategories.size());

        assertThat(subCategories).isNotNull();
    }

    @Test
    void getCategoryByCategoryId() {
        Long categoryId = 2L;

        Category category = postService.getCategoryByCategoryId(categoryId);
        System.out.println(category);

//        assertThat(category).isNotNull();
    }
}