package com.userpanel.userpanel.dto;

import lombok.Value;

@Value
public class JwtDTO {
    String token;
    String email;
}
