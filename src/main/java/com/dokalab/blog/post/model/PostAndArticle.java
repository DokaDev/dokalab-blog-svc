package com.dokalab.blog.post.model;

import lombok.Data;

@Data
public class PostAndArticle {
    private Long postId;
    private PostMeta postMeta;
    private Article article;
}
