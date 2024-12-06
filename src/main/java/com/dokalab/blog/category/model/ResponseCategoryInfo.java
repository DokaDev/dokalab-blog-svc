package com.dokalab.blog.category.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class ResponseCategoryInfo {
    private Long id;
    private String name;
    private Boolean isSubCategory;
    private Long parentId;

    @Setter
    private Long postCount = 0L;

    public ResponseCategoryInfo(CategoryDto categoryDto) {
        this.id = categoryDto.getCategoryId();
        this.name = categoryDto.getCategoryName();
        if(categoryDto.getParentCategory() != null) {
            this.parentId = categoryDto.getParentCategory().getCategoryId();
        }
        this.isSubCategory = this.parentId != null;

    }
}
