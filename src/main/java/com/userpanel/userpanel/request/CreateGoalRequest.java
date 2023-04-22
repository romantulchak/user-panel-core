package com.userpanel.userpanel.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;

@Value
public class CreateGoalRequest {

    @NotNull
    @Size(min = 1, max = 50) String name;
    @Min(1) double price;
    boolean isActive;
    UUID categoryId;
}
