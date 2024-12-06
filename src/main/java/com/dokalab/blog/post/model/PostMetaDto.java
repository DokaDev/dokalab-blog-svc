package com.dokalab.blog.post.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostMetaDto {
    private Long postId;
    private String postTitle;
    private LocalDateTime postDate;
    private Boolean isVisible;
    private Long categoryId;
    private String status;

    private String summary;
}
