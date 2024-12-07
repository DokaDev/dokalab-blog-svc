package com.dokalab.blog.post;

import org.apache.ibatis.annotations.Mapper;
import com.dokalab.blog.post.model.*;

import java.util.List;

@Mapper
public interface PostMapper {
    Long getPostCountByCategoryId(Long categoryId);
    CategoryAndPostDto getCategoryWithPosts(Long categoryId);
    List<PostMetaDto> getPostsByCategory(Long categoryId);
    List<AllPostsWithCategoryDto> getAllPostsWithCategory();
    PostMetaAndArticle getPostById(Long postId);
}
