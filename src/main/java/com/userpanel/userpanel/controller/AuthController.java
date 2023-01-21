package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.JwtDTO;
import com.userpanel.userpanel.request.LoginRequest;
import com.userpanel.userpanel.request.SignUpRequest;
import com.userpanel.userpanel.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("sign-in")
    public JwtDTO singIn(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }

    @PostMapping("sign-up")
    public void signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
    }

}
