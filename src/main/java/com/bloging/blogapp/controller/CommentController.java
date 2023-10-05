package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.comment.CommentResponseModel;
import com.bloging.blogapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{postId}")
    public List<CommentResponseModel> getAllPostComments(
            @PathVariable int postId
    ) {
        return commentService.getAllPostComments(postId);
    }

    @PostMapping("/{postId}")
    public CommentResponseModel createNewComment(
            @RequestBody CommentRequestModel request,
            @PathVariable int postId
    ) {
        return commentService.createNewComment(request, postId);
    }

    @PutMapping("/{commentId}")
    public CommentResponseModel updateMyCommentById(
            @RequestBody CommentRequestModel request,
            @PathVariable int commentId
    ) {
        return commentService.updateMyCommentById(request, commentId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteMyComment(@PathVariable int commentId) {
        commentService.deleteMyCommentById(commentId);
    }

}
