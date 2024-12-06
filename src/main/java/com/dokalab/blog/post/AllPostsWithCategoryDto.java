package com.dokalab.blog.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllPostsWithCategoryDto {
    private Long id;
    private String title;
    private String summary;

    private Long categoryId;
    private String categoryName;

    private Long parentId;
    private String parentName;

    private LocalDateTime postDate;
}
