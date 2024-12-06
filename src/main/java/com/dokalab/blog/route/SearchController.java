package com.dokalab.blog.route;

import com.dokalab.blog.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final PostService postService;
}
