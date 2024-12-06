package com.dokalab.blog.post.model;

import lombok.Data;

import java.util.List;

@Data
public class CategoryAndPostDto {
    private Long id;
    private String name;
    private Long parentId;
    private String parentName;
    private List<PostMetaDto> posts;
}
