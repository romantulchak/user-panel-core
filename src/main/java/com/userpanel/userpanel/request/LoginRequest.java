package com.userpanel.userpanel.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class LoginRequest {
    @Email
    @NotNull
    String email;
    @NotNull
    String password;
}
