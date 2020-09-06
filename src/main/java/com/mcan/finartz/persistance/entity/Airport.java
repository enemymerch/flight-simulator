package com.mcan.finartz.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Airport extends BaseEntity {

    @Column(name = "NAME", length = 124, unique = true, nullable = false)
    private String name;
    @Column(name = "CITY", length = 124, nullable = false)
    private String city;

    @OneToMany(mappedBy = "departureAirport", fetch = FetchType.LAZY)
    private List<Route> departureAirportRoutes;

    @OneToMany(mappedBy = "arrivalAirport", fetch = FetchType.LAZY)
    private List<Route> arrivalAirportRoutes;

}
