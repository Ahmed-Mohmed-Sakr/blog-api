package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.user.UserRequestUpdateModel;
import com.bloging.blogapp.model.user.UserResponseModel;
import com.bloging.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserResponseModel> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping(params = "id")
    public UserResponseModel getUserById(@RequestParam(name = "id") int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(params = "email")
    public UserResponseModel getUserByEmail(@RequestParam(name = "email")String UserEmail) {
        return userService.getUserByEmail(UserEmail);
    }

    @PutMapping("")
    public UserResponseModel updateUser(@RequestBody UserRequestUpdateModel request) {
        return userService.updateMyProfile(request);
    }

    @DeleteMapping("")
    public void deleteMyAccount() {
        userService.deleteMyProfile();
    }

}
