package com.userpanel.userpanel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class GoalCategory {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String iconPath;
    @ManyToOne
    private Account account;

    public GoalCategory() {
    }

    public GoalCategory(String name, String iconPath, Account account) {
        this.name = name;
        this.iconPath = iconPath;
        this.account = account;
    }
}
