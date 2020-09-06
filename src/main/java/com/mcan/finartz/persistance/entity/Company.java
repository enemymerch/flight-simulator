package com.mcan.finartz.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Company extends BaseEntity {

    @Column(name = "NAME", length = 124, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Flight> flightList;
}
