package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.dto.JwtDTO;
import com.userpanel.userpanel.exception.UserAlreadyExistsException;
import com.userpanel.userpanel.model.User;
import com.userpanel.userpanel.repository.UserRepository;
import com.userpanel.userpanel.request.LoginRequest;
import com.userpanel.userpanel.request.SignUpRequest;
import com.userpanel.userpanel.security.jwt.JwtUtils;
import com.userpanel.userpanel.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    public JwtDTO signIn(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtUtils.generateJwtToken(authenticate);
        return new JwtDTO(token, loginRequest.getEmail());
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExistsException(signUpRequest.getEmail());
        }
        User user = new User()
                .setEmail(signUpRequest.getEmail())
                .setName(signUpRequest.getFullName())
                .setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
    }
}
