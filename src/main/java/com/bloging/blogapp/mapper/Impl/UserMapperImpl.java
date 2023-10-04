package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.mapper.UserMapper;
import com.bloging.blogapp.model.user.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseModel toResponse(User user) {
        return UserResponseModel
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
