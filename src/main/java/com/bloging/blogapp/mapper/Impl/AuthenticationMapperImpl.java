package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.myenum.Role;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.mapper.AuthenticationMapper;
import com.bloging.blogapp.model.auth.AuthenticationResponseModel;
import com.bloging.blogapp.model.auth.RegisterRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
@RequiredArgsConstructor
public class AuthenticationMapperImpl implements AuthenticationMapper {

    private final PasswordEncoder passwordEncoder;
    @Override
    public User toEntity(RegisterRequestModel requestModel) {
        return User.builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .email(requestModel.getEmail())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .role(Role.USER)
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    @Override
    public AuthenticationResponseModel toAuthResponse(String token) {
        return AuthenticationResponseModel
                .builder()
                .token(token)
                .build();
    }
}
