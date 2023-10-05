package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.mapper.PostMapper;
import com.bloging.blogapp.mapper.TagMapper;
import com.bloging.blogapp.mapper.UserMapper;
import com.bloging.blogapp.model.post.PostRequestModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class PostMapperImpl implements PostMapper {

    private final UserMapper userMapper;
    private final TagMapper tagMapper;
    @Override
    public PostResponseModel toResponse(Post post) {
        return PostResponseModel
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .summary(post.getSummary())
                .updatedAt(post.getUpdatedAt())
                .publishedAt(post.getPublishedAt())
                .LikesCount(post.getLikes().size())
                .Author(userMapper.toResponse(post.getUser()))
                .tags(post.getTags().stream().map(tagMapper::toResponse).toList())
                .build();
    }

    @Override
    public Post toEntity(PostRequestModel request, User user) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .summary(request.getSummary())
                .publishedAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .user(user)
                .likes(new ArrayList<>())
                .categories(new ArrayList<>())
                .tags(new ArrayList<>())
                .build();
    }
}
