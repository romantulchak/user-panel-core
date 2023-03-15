package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.component.FinanceTransformer;
import com.userpanel.userpanel.dto.FinanceDTO;
import com.userpanel.userpanel.model.Finance;
import com.userpanel.userpanel.model.type.FinanceType;
import com.userpanel.userpanel.repository.FinanceRepository;
import com.userpanel.userpanel.request.FinanceRequest;
import com.userpanel.userpanel.security.UserDetailsImpl;
import com.userpanel.userpanel.service.FinanceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.userpanel.userpanel.model.type.FinanceType.EXPENSE;
import static com.userpanel.userpanel.model.type.FinanceType.INCOME;

@Service
@AllArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository financeRepository;
    private final FinanceTransformer financeTransformer;

    @Override
    public void createIncome(FinanceRequest financeRequest) {
        createFinance(financeRequest, INCOME);
    }

    @Override
    public void createExpense(FinanceRequest financeRequest) {
        createFinance(financeRequest, EXPENSE);
    }

    @Override
    public FinanceDTO getFinanceInfo(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UUID id = userDetails.getId();
        List<Finance> finances = financeRepository.getAllByAccountUserId(id);
        double income = finances.stream()
                .filter(finance -> finance.getType() == INCOME)
                .mapToDouble(Finance::getValue)
                .sum();
        double expense = finances.stream()
                .filter(finance -> finance.getType() == EXPENSE)
                .mapToDouble(Finance::getValue)
                .sum();
        return financeTransformer.convert(income, expense, finances);
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
