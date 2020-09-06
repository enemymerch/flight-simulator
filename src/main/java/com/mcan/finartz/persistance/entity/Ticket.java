package com.mcan.finartz.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Ticket extends BaseEntity {

    @Column(nullable = false)
    private String passenger;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID", nullable = false)
    private Purchase purchase;
}
