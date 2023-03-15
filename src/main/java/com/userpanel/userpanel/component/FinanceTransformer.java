package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.FinanceDTO;
import com.userpanel.userpanel.dto.IncomeExpenseDTO;
import com.userpanel.userpanel.model.Finance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinanceTransformer {


    public FinanceDTO convert(double totalIncome, double totalExpense, List<Finance> finances) {
        List<IncomeExpenseDTO> incomeExpense = finances.stream()
                .map(finance -> new IncomeExpenseDTO(finance.getValue(), finance.getDate(), finance.getType()))
                .toList();
        double cash = totalIncome - totalExpense;
        double cashOnHand = cash < 0 ? 0 : cash;
        return new FinanceDTO(totalIncome, totalExpense, cashOnHand, incomeExpense);
    }
}
