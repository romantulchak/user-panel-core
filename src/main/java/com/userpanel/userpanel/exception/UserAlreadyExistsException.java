package com.userpanel.userpanel.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super(String.join(" ", "User already exists with email:", email));
    }
}
