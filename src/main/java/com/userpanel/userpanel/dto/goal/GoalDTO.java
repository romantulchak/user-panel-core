package com.userpanel.userpanel.dto.goal;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class GoalDTO {

    private UUID id;
    private String name;
    private double price;
    private boolean isActive;
    private GoalCategoryDTO category;
    private LocalDate addDate;
    private double percentToCompletion;

    public GoalDTO(UUID id, String name, double price, boolean isActive, GoalCategoryDTO category, LocalDate addDate, double percentToCompletion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isActive = isActive;
        this.category = category;
        this.addDate = addDate;
        this.percentToCompletion = percentToCompletion;
    }
}
