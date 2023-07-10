package com.userpanel.userpanel.dto.purchase;


import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class PurchaseDTO {
    UUID id;
    String name;
    ShopTypeDTO shopType;
    int itemCount;
    LocalDateTime purchaseDate;
    List<ItemDTO> items;
    double price;
}
