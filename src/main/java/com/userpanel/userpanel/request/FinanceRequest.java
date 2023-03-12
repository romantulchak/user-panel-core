package com.userpanel.userpanel.request;

import com.userpanel.userpanel.model.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class FinanceRequest {

    @NotNull
    Account account;
    @NotNull
    double value;

}
