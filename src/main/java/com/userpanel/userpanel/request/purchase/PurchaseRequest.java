package com.userpanel.userpanel.request.purchase;

import com.userpanel.userpanel.model.purchase.ShopType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseRequest {

    @Nullable
    private String name;
    @NotNull
    private ShopType shop;
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    @Size(min = 1)
    private List<ItemRequest> items;
}
