package com.userpanel.userpanel.dto;

import com.userpanel.userpanel.model.Account;
import com.userpanel.userpanel.model.type.FinanceType;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class FinanceDTO {
    UUID id;
    double value;
    LocalDateTime date;
    FinanceType type;
    Account account;
}
