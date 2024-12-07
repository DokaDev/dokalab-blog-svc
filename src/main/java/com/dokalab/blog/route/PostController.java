package com.dokalab.blog.route;

import com.dokalab.blog.post.*;
import com.dokalab.blog.post.model.*;
import com.dokalab.blog.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
    
    private final PostService postService;

    @GetMapping("/all/post")
    public ResponseEntity<List<AllPostsWithCategoryDto>> getAllPosts() {
        log.info("Requesting all posts");
        List<AllPostsWithCategoryDto> result = postService.getAllPostsWithCategory();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryAndPostDto> getPostsByCategory(@PathVariable Long categoryId) {
        System.out.println("카테고리별 포스트 요청 받음");
        CategoryAndPostDto result = postService.getCategoryWithPosts(categoryId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/parent-category/{parentId}")
    public ResponseEntity<List<AllPostsWithCategoryDto>> getPostsByParentCategory(
            @PathVariable Long parentId) {
        log.info("Requesting posts for parent category: {}", parentId);
        List<AllPostsWithCategoryDto> result = postService.getPostsByParentCategory(parentId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AllPostsWithCategoryDto>> searchPosts(
            @RequestParam String keyword) {
        log.info("Searching posts with keyword: {}", keyword);
        List<AllPostsWithCategoryDto> result = postService.searchPosts(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("article/{postId}")
    public ResponseEntity<PostMetaAndArticle> getPostById(@PathVariable Long postId) {
        log.info("Requesting post with id: {}", postId);
        PostMetaAndArticle post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Error processing request", e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred: " + e.getMessage());
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundException e) {
        log.warn("Post not found: {}", e.getMessage());
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e.getMessage());
    }
}
