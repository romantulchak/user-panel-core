package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.FinanceDTO;
import com.userpanel.userpanel.request.FinanceRequest;
import org.springframework.security.core.Authentication;

public interface FinanceService {

    void createIncome(FinanceRequest financeRequest);

    void createExpense(FinanceRequest financeRequest);

    FinanceDTO getFinanceInfo(Authentication authentication);
}
