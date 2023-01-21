package com.userpanel.userpanel.request;

import lombok.Value;

@Value
public class SignUpRequest {

    String firstName;
    String lastName;
    String email;
    String password;

    public String getFullName() {
        return String.join(" ", firstName, lastName);
    }

}
