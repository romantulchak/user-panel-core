package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.JwtDTO;
import com.userpanel.userpanel.request.LoginRequest;
import com.userpanel.userpanel.request.SignUpRequest;

public interface AuthService {

    JwtDTO signIn(LoginRequest loginRequest);

    void signUp(SignUpRequest signUpRequest);
}
