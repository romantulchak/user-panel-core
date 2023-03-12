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
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany(mappedBy = "account")
    private List<Finance> finances;

    @OneToOne
    private User user;

    public Account() {

    }

    public Account(User user) {
        this.user = user;
    }
}
