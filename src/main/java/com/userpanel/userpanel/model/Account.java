package com.userpanel.userpanel.model;

import com.userpanel.userpanel.model.purchase.Purchase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Finance> finances;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Goal> goals;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<GoalCategory> categories;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    @OneToOne
    private User user;

    @Column(name = "amount")
    private double balance;

    public Account() {

    }

    public Account(User user) {
        this.user = user;
    }
}
