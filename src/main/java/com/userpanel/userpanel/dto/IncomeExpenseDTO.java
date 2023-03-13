package com.userpanel.userpanel.dto;

import com.userpanel.userpanel.model.type.FinanceType;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class IncomeExpenseDTO {
    double value;
    LocalDateTime date;
    FinanceType type;
}
