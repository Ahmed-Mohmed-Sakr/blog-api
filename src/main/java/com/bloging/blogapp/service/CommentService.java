package com.bloging.blogapp.service;

import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.comment.CommentResponseModel;

import java.util.List;

public interface CommentService {
    List<CommentResponseModel> getAllPostComments(int postId);

    CommentResponseModel createNewComment(CommentRequestModel request, int postId);

    CommentResponseModel updateMyCommentById(CommentRequestModel request, int commentId);

    void deleteMyCommentById(int commentId);
}
