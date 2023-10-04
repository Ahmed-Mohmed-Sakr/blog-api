package com.bloging.blogapp.service;

import com.bloging.blogapp.model.user.UserRequestUpdateModel;
import com.bloging.blogapp.model.user.UserResponseModel;

import java.util.List;

public interface UserService {

    List<UserResponseModel> getAllUsers();

    UserResponseModel getUserById(int id);

    UserResponseModel getUserByEmail(String email);

    UserResponseModel updateMyProfile(UserRequestUpdateModel request);

    void deleteMyProfile();

}
