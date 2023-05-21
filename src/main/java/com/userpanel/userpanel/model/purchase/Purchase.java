package com.userpanel.userpanel.model.purchase;

import com.userpanel.userpanel.model.Account;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Nullable
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ShopType shop;

    @NotNull
    private LocalDateTime dateTime;

    private int itemCount;
    @OneToMany(mappedBy = "purchase")
    private List<Item> items;

    @ManyToOne
    private Account account;
}