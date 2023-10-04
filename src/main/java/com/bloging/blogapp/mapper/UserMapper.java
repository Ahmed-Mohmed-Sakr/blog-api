package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.model.user.UserResponseModel;

public interface UserMapper {
    UserResponseModel toResponse(User user);
}
