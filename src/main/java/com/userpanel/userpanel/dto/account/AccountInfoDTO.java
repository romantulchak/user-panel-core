package com.userpanel.userpanel.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountInfoDTO {

    private String email;
    private double balance;

}
