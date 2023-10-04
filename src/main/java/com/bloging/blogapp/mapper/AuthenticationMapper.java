package com.bloging.blogapp.mapper;


import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.model.auth.AuthenticationResponseModel;
import com.bloging.blogapp.model.auth.RegisterRequestModel;

public interface AuthenticationMapper {
    User toEntity(RegisterRequestModel requestModel);

    AuthenticationResponseModel toAuthResponse(String token);
}
