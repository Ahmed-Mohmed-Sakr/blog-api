package com.bloging.blogapp.mapper;


import com.bloging.blogapp.entity.Comment;
import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.comment.CommentResponseModel;

public interface CommentMapper {

    CommentResponseModel toResponse(Comment comment);

    Comment toEntity(CommentRequestModel request, User user, Post post);

}
