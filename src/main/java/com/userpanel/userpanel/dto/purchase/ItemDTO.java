package com.userpanel.userpanel.dto.purchase;

import lombok.Value;

import java.util.UUID;

@Value
public class ItemDTO {
    UUID id;
    String name;
    double price;
    int amount;
}
