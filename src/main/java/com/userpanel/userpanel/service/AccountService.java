package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.account.AccountInfoDTO;
import com.userpanel.userpanel.model.User;
import org.springframework.security.core.Authentication;

public interface AccountService {

    void create(User user);

    AccountInfoDTO getInfo(Authentication authentication);
}
