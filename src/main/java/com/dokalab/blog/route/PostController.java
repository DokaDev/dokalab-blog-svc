package com.dokalab.blog.route;

import com.dokalab.blog.post.*;
import com.dokalab.blog.post.model.CategoryAndPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;

    @GetMapping("/all/post")
    public ResponseEntity<List<AllPostsWithCategoryDto>> getAllPosts() {
        List<AllPostsWithCategoryDto> result = postService.getAllPostsWithCategory();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryAndPostDto> getPostsByCategory(@PathVariable Long categoryId) {
        System.out.println("카테고리별 포스트 요청 받음");
        CategoryAndPostDto result = postService.getCategoryWithPosts(categoryId);
        return ResponseEntity.ok(result);
    }
}
