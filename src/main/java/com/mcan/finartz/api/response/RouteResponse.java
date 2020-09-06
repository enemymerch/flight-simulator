package com.mcan.finartz.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteResponse extends BaseResponse {
    private AirportResponse departureAirport;
    private AirportResponse arrivalAirport;
}
