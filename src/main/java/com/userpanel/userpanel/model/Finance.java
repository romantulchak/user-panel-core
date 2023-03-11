package com.userpanel.userpanel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Finance {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany(mappedBy = "finance")
    private List<Income> incomes;

    @OneToMany(mappedBy = "finance")
    private List<Expense> expenses;

    @OneToOne
    private User user;
}
