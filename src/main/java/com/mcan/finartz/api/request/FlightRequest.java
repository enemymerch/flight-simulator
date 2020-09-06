package com.mcan.finartz.api.request;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class FlightRequest extends BaseRequest{
    private Long companyId;
    private Long routeId;
    private Date departureDate;
    private Date arrivalDate;
    private Short passengerCapacity;
    private BigDecimal ticketPrice;
}
