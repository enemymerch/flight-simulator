package com.mcan.finartz.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DEPARTURE_AIRPORT_ID", "ARRIVAL_AIRPORT_ID"})
})
@Getter
@Setter
public class Route extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "DEPARTURE_AIRPORT_ID", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "ARRIVAL_AIRPORT_ID", nullable = false)
    private Airport arrivalAirport;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<Flight> flightList;
}
