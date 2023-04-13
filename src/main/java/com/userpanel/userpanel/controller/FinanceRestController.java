package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.FinanceDTO;
import com.userpanel.userpanel.service.FinanceService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*", maxAge = 3600L)
@RequestMapping("/api/v1/finance")
@AllArgsConstructor
public class FinanceRestController {

    private final FinanceService financeService;

    @GetMapping("/info")
    @PreAuthorize("isAuthenticated()")
    public FinanceDTO getFinanceInfo(Authentication authentication) {
        return financeService.getFinanceInfo(authentication);
    }
}
