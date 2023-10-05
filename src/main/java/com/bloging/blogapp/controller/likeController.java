package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.like.LikeResponseModel;
import com.bloging.blogapp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class likeController {

    private final LikeService likeService;

    @GetMapping("/{postId}")
    public List<LikeResponseModel> getAllPostLikes(
            @PathVariable int postId
    ) {
        return likeService.getAllPostLikess(postId);
    }

    @PostMapping("/{postId}")
    public LikeResponseModel AddLikeToPost(
            @PathVariable int postId
    ) {
        return likeService.AddLikeToPost(postId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteMyLike(@PathVariable int likeId) {
        likeService.deleteMyLike(likeId);
    }

}
