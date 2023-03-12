package com.userpanel.userpanel.model;

import com.userpanel.userpanel.model.type.FinanceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Finance {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    private double value;

    @NotNull
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private FinanceType type;

    @ManyToOne
    private Account account;
}
