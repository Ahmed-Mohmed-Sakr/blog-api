package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.Like;
import com.bloging.blogapp.model.like.LikeResponseModel;

public interface LikeMapper {
    LikeResponseModel toResponse(Like like);
}
