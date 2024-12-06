package com.dokalab.blog.post;

import com.dokalab.blog.category.CategoryService;
import com.dokalab.blog.category.model.ResponseCategoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/category/list")
    public ResponseEntity<List<ResponseCategoryInfo>> getAllCategories() {
        System.out.println("카테고리 목록 요청 받음");
        return ResponseEntity.ok(categoryService.getCategoryInfoAsResponseModel());
    }
}
