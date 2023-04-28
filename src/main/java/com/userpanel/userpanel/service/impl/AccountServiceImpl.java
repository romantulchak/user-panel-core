package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.component.AccountTransformer;
import com.userpanel.userpanel.dto.account.AccountInfoDTO;
import com.userpanel.userpanel.model.Account;
import com.userpanel.userpanel.model.User;
import com.userpanel.userpanel.repository.AccountRepository;
import com.userpanel.userpanel.request.FinanceRequest;
import com.userpanel.userpanel.security.UserDetailsImpl;
import com.userpanel.userpanel.service.AccountService;
import com.userpanel.userpanel.service.FinanceService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final FinanceService financeService;
    private final AccountTransformer accountTransformer;

    @Override
    @Transactional
    public void create(User user) {
        Account account = new Account(user);
        Account accountAftersSave = accountRepository.save(account);
        FinanceRequest financeRequest = new FinanceRequest(accountAftersSave, 0.0);
        financeService.createIncome(financeRequest);
        financeService.createExpense(financeRequest);
    }

    @Override
    public AccountInfoDTO getInfo(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByUserId(userDetails.getId());
        return accountTransformer.convertToDto(account);
    }
}
