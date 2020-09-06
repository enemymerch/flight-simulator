package com.mcan.finartz.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDto extends BaseDto {
    private AirportDto departureAirport;
    private AirportDto arrivalAirport;
}
