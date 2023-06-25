package com.userpanel.userpanel.projection.purchase;

import com.userpanel.userpanel.model.purchase.ShopType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PurchaseProjection {
    UUID getId();
    String getName();
    ShopType getShop();
    LocalDateTime getDateTime();
    int getItemCount();
}
