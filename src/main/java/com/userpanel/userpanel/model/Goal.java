package com.userpanel.userpanel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
}
