package com.dokalab.blog.post.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostMetaAndArticle {
    private Long postId;
    private String postTitle;
    private String postContent;

    private LocalDateTime createdAt;

    private Long categoryId;
    private String categoryName;

    private Long parentCategoryId;
    private String parentCategoryName;
}
