package com.dokalab.blog.post.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostMeta {
    private Long postId;
    private String postTitle;
    private LocalDateTime createdAt;
    private Boolean isVisible;
    private PostStatus status;
    private Long categoryId;
}
