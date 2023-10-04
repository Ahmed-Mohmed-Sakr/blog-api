package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.UserMapper;
import com.bloging.blogapp.model.user.UserRequestUpdateModel;
import com.bloging.blogapp.model.user.UserResponseModel;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseModel> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse).toList();
    }

    @Override
    public UserResponseModel getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User ID " + id + " Not Found!"));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponseModel getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponseModel updateMyProfile(UserRequestUpdateModel request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public void deleteMyProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        userRepository.delete(user);
    }
}
