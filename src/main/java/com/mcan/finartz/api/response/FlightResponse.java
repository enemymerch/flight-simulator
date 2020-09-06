package com.mcan.finartz.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class FlightResponse extends BaseResponse {
    private CompanyResponse company;
    private RouteResponse route;
    private Date departureDate;
    private Date arrivalDate;
    private Short passengerCapacity;
    private BigDecimal ticketPrice;
}
