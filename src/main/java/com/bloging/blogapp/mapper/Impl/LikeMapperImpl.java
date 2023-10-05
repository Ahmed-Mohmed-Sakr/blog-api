package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Like;
import com.bloging.blogapp.mapper.LikeMapper;
import com.bloging.blogapp.mapper.UserMapper;
import com.bloging.blogapp.model.like.LikeResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeMapperImpl implements LikeMapper {

    private final UserMapper userMapper;

    @Override
    public LikeResponseModel toResponse(Like like) {
        return LikeResponseModel
                .builder()
                .id(like.getId())
                .createdAt(like.getCreatedAt())
                .user(userMapper.toResponse(like.getUser()))
                .build();
    }
}
