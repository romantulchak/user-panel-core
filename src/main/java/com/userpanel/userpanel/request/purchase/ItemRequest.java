package com.userpanel.userpanel.request.purchase;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemRequest {

    @NotNull
    @Size(max = 99)
    private String name;
    @Min(0)
    private double price;
    @Min(1)
    private int amount;
}
