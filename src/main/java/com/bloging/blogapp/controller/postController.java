package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.post.PostRequestModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class postController {

    private final PostService postService;

    @GetMapping()
    public List<PostResponseModel> getAllPosts(
            @RequestParam(required = false,defaultValue = "0") int page
    ) {
        return postService.getAllPosts(page);
    }

    @GetMapping("/{userId}")
    public List<PostResponseModel> getUserPostsById(
            @PathVariable int userId,
            @RequestParam(required = false,defaultValue = "0") int page
    ) {
        return postService.getPostsByUserId(userId, page);
    }

    @PostMapping("")
    public PostResponseModel createNewPost(@RequestBody PostRequestModel request) {
        return postService.createNewPost(request);
    }

    @PutMapping("/{postId}")
    public PostResponseModel updateMyPostById(
            @RequestBody PostRequestModel request,
            @PathVariable int postId
    ) {
        return postService.updateMyPostById(request, postId);
    }

    @DeleteMapping("/{postId}")
    public void deleteMyPost(@PathVariable int postId) {
        postService.deleteMyPostById(postId);
    }

}
