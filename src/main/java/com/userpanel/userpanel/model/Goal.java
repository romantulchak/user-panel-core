package com.userpanel.userpanel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Goal {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    private String name;

    private double price;

    private boolean isActive;

    @NotNull
    private String iconPath;

    @NotNull
    @OneToOne
    private GoalCategory category;

    @NotNull
    @ManyToOne
    private Account account;

    private LocalDate addDate;

    public Goal() {
    }

    public Goal(String name, double price, boolean isActive, String iconPath, GoalCategory category, Account account) {
        this.name = name;
        this.price = price;
        this.isActive = isActive;
        this.iconPath = iconPath;
        this.category = category;
        this.account = account;
        this.addDate = LocalDate.now();
    }
}
