package com.dokalab.blog.post;

import com.dokalab.blog.category.CategoryMapper;
import com.dokalab.blog.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dokalab.blog.post.model.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostMapper postMapper;
    private final CategoryMapper categoryMapper;

    public Long getPostCountByCategoryId(Long categoryId) {
        return postMapper.getPostCountByCategoryId(categoryId);
    }

    public CategoryAndPostDto getCategoryWithPosts(Long categoryId) {
        CategoryAndPostDto result = postMapper.getCategoryWithPosts(categoryId);
        if (result != null && result.getPosts() != null) {
            List<PostMetaDto> filteredPosts = result.getPosts().stream()
                .filter(post -> post.getPostId() != null)
                .collect(Collectors.toList());
            result.setPosts(filteredPosts);
        }
        return result;
    }

    public List<PostMetaDto> getPostsByCategory(Long categoryId) {
        return postMapper.getPostsByCategory(categoryId);
    }

    public List<AllPostsWithCategoryDto> getAllPostsWithCategory() {
        List<AllPostsWithCategoryDto> posts = postMapper.getAllPostsWithCategory();
        if (posts == null || posts.isEmpty()) {
            log.info("No posts found");
            return Collections.emptyList();
        }
        log.info("Found {} posts", posts.size());
        return posts;
    }

    public List<AllPostsWithCategoryDto> getPostsByParentCategory(Long parentCategoryId) {
        List<AllPostsWithCategoryDto> allPosts = getAllPostsWithCategory();
        return allPosts.stream()
            .filter(post -> parentCategoryId.equals(post.getParentId()))
            .collect(Collectors.toList());
    }

    public List<AllPostsWithCategoryDto> searchPosts(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return Collections.emptyList();
        }
        
        List<AllPostsWithCategoryDto> allPosts = getAllPostsWithCategory();
        return allPosts.stream()
            .filter(post -> 
                (post.getTitle() != null && post.getTitle().toLowerCase().contains(keyword.toLowerCase())) ||
                (post.getSummary() != null && post.getSummary().toLowerCase().contains(keyword.toLowerCase())) ||
                (post.getCategoryName() != null && post.getCategoryName().toLowerCase().contains(keyword.toLowerCase()))
            )
            .collect(Collectors.toList());
    }

    public PostMetaAndArticle getPostById(Long postId) {
        log.info("Fetching post with id: {}", postId);
        PostMetaAndArticle post = postMapper.getPostById(postId);
        
        if (post == null) {
            log.warn("No post found with id: {}", postId);
            throw new PostNotFoundException("Post not found with id: " + postId);
        }
        
        log.info("Successfully fetched post with id: {}", postId);
        return post;
    }
}
