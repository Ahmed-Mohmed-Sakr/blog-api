package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.AuthenticationMapper;
import com.bloging.blogapp.model.auth.AuthenticationRequestModel;
import com.bloging.blogapp.model.auth.AuthenticationResponseModel;
import com.bloging.blogapp.model.auth.RegisterRequestModel;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.security.JwtService;
import com.bloging.blogapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationMapper authenticationMapper;

    @Override
    public AuthenticationResponseModel register(RegisterRequestModel request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new NotAuthToSeeResourseException("Email or Phone Number is already exists");
        }


        User user = authenticationMapper.toEntity(request);
        userRepository.save(user);

        return authenticationMapper.toAuthResponse(jwtService.generateToken(user));
    }

    @Override
    public AuthenticationResponseModel authenticate(AuthenticationRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                ));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email is already exists"));

        return authenticationMapper.toAuthResponse(jwtService.generateToken(user));
    }
}
