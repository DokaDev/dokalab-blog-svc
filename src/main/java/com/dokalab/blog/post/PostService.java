package com.dokalab.blog.post;

import com.dokalab.blog.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dokalab.blog.post.model.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
        return postMapper.getAllPostsWithCategory();
    }
}
