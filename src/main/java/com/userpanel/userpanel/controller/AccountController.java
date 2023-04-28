package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.account.AccountInfoDTO;
import com.userpanel.userpanel.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(value = "*", maxAge = 3600L)
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/info")
    public AccountInfoDTO getInfo(Authentication authentication) {
        return accountService.getInfo(authentication);
    }
}
