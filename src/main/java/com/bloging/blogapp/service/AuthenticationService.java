package com.bloging.blogapp.service;

import com.bloging.blogapp.model.auth.AuthenticationRequestModel;
import com.bloging.blogapp.model.auth.AuthenticationResponseModel;
import com.bloging.blogapp.model.auth.RegisterRequestModel;

public interface AuthenticationService {
    AuthenticationResponseModel register(RegisterRequestModel request);

    AuthenticationResponseModel authenticate(AuthenticationRequestModel request);
}
