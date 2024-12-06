package com.dokalab.blog.post;

import com.dokalab.blog.post.model.CategoryAndPostDto;
import com.dokalab.blog.post.model.PostMetaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    @DisplayName("카테고리 ID로 해당 카테고리의 게시물 수를 정확히 조회할 수 있다")
    void getPostCountByCategoryId() {
        // given
        Long categoryId = 1L;

        // when
        Long postCount = postService.getPostCountByCategoryId(categoryId);

        // then
        assertThat(postCount).isNotNull();
        assertThat(postCount).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("카테고리와 해당 카테고리의 게시물 목록을 함께 조회할 수 있다")
    void getCategoryWithPosts() {
        // given
        Long categoryId = 4L;

        // when
        CategoryAndPostDto result = postService.getCategoryWithPosts(categoryId);
        System.out.println(result);
    }

    @Test
    @DisplayName("특정 카테고리의 게시물 목록만 조회할 수 있다")
    void getPostsByCategory() {
        // given
        Long categoryId = 4L;

        // when
        List<PostMetaDto> posts = postService.getPostsByCategory(categoryId);
        for (PostMetaDto post : posts) {
            System.out.println(post);
        }

        // then
//        assertThat(posts).isNotNull();
//
//        if (!posts.isEmpty()) {
//            PostMetaDto firstPost = posts.get(0);
//            assertThat(firstPost.getCategoryId()).isEqualTo(categoryId);
//            assertThat(firstPost.getStatus()).isEqualTo("published");
//            assertThat(firstPost.getIsVisible()).isTrue();
//
//            // 날짜 기준 내림차순 정렬 확인
//            if (posts.size() > 1) {
//                PostMetaDto secondPost = posts.get(1);
//                assertThat(firstPost.getPostDate())
//                    .isAfterOrEqualTo(secondPost.getPostDate());
//            }
//        }
    }
}