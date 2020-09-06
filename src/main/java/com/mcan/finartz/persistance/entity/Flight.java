package com.mcan.finartz.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Flight extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "ROUTE_ID", nullable = false)
    private Route route;

    @Column(nullable = false)
    private Date departureDate;

    @Column(nullable = false)
    private Date arrivalDate;

    @Column(nullable = false)
    private Short passengerCapacity;

    @Column(nullable = false)
    private BigDecimal ticketPrice;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;
}
