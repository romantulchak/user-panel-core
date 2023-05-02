package com.userpanel.userpanel.exception.account;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("Account not found");
    }

    public AccountNotFoundException(UUID id) {
        super(String.format("Account with id %s not found", id));
    }
}
