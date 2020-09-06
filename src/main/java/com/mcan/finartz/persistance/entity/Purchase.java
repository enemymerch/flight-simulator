package com.mcan.finartz.persistance.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Purchase extends BaseEntity {

    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Ticket> tickets;

    @Column(nullable = false, length = 16)
    private String creditCardNumber;

    @Column
    private Short purchasedTicketCount;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column
    private String billingAddress;
}
