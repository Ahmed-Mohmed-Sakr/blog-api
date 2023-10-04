package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.auth.AuthenticationResponseModel;
import com.bloging.blogapp.model.auth.RegisterRequestModel;
import com.bloging.blogapp.model.auth.AuthenticationRequestModel;
import com.bloging.blogapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseModel> register(
            @RequestBody RegisterRequestModel request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseModel> authenticate(
            @RequestBody AuthenticationRequestModel request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
