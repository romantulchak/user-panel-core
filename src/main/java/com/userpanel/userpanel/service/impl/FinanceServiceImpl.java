package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.model.Finance;
import com.userpanel.userpanel.model.type.FinanceType;
import com.userpanel.userpanel.repository.FinanceRepository;
import com.userpanel.userpanel.request.FinanceRequest;
import com.userpanel.userpanel.service.FinanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.userpanel.userpanel.model.type.FinanceType.EXPENSE;
import static com.userpanel.userpanel.model.type.FinanceType.INCOME;

@Service
@AllArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository financeRepository;

    @Override
    public void createIncome(FinanceRequest financeRequest) {
        createFinance(financeRequest, INCOME);
    }

    @Override
    public void createExpense(FinanceRequest financeRequest) {
        createFinance(financeRequest, EXPENSE);
    }

    private void createFinance(FinanceRequest financeRequest, FinanceType expense) {
        Finance finance = Finance.builder()
                .withAccount(financeRequest.getAccount())
                .withValue(financeRequest.getValue())
                .withDate(LocalDateTime.now())
                .withType(expense)
                .build();
        financeRepository.save(finance);
    }
}
