package com.userpanel.userpanel.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SignUpRequest {

    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @Size(min = 5, max = 35)
    @NotNull
    @Email
    String email;
    @Size(min = 8, max = 24)
    @NotNull
    String password;

    public String getFullName() {
        return String.join(" ", firstName, lastName);
    }

}
