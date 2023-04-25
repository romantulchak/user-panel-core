package com.userpanel.userpanel.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateGoalRequest {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @Min(1)
    private double price;
    private boolean isActive;
    private String categoryName;

    public CreateGoalRequest() {
    }
}
