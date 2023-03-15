package com.userpanel.userpanel.dto;

import lombok.Value;

import java.util.List;

@Value
public class FinanceDTO {
    double income;
    double expense;
    double cashOnHand;
    List<IncomeExpenseDTO> incomeExpenses;
}
