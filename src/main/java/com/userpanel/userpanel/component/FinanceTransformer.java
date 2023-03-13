package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.FinanceDTO;
import com.userpanel.userpanel.dto.IncomeExpenseDTO;
import com.userpanel.userpanel.model.Finance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinanceTransformer {


    public FinanceDTO convert(double income, double expense, List<Finance> finances) {
        List<IncomeExpenseDTO> incomeExpense = finances.stream()
                .map(finance -> new IncomeExpenseDTO(finance.getValue(), finance.getDate(), finance.getType()))
                .toList();
        return new FinanceDTO(income, expense, incomeExpense);
    }
}
