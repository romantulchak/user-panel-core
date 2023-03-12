package com.userpanel.userpanel.service;

import com.userpanel.userpanel.request.FinanceRequest;

public interface FinanceService {

    void createIncome(FinanceRequest financeRequest);

    void createExpense(FinanceRequest financeRequest);
}
