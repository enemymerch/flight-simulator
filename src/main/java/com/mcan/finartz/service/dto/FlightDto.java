package com.mcan.finartz.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class FlightDto extends BaseDto {
    private CompanyDto company;
    private RouteDto route;
    private Date departureDate;
    private Date arrivalDate;
    private Short passengerCapacity;
    private BigDecimal ticketPrice;
}
