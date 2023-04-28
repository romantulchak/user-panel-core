package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.account.AccountInfoDTO;
import com.userpanel.userpanel.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountTransformer {

    public AccountInfoDTO convertToDto(Account account) {
        return new AccountInfoDTO(account.getUser().getEmail(), account.getBalance());
    }
}
