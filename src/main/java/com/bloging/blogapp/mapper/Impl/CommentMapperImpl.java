package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Comment;
import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.mapper.CommentMapper;
import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.comment.CommentResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class CommentMapperImpl implements CommentMapper {
    @Override
    public CommentResponseModel toResponse(Comment comment) {
        return CommentResponseModel
                .builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    @Override
    public Comment toEntity(CommentRequestModel request, User user, Post post) {
        return Comment
                .builder()
                .content(request.getContent())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .user(user)
                .post(post)
                .build();
    }
}
