package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.JwtDTO;
import com.userpanel.userpanel.request.LoginRequest;
import com.userpanel.userpanel.request.SignUpRequest;
import com.userpanel.userpanel.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(value = "*", maxAge = 3600L)
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public JwtDTO singIn(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }

    @PostMapping("/sign-up")
    public void signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
    }

}
