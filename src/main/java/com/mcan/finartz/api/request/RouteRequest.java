package com.mcan.finartz.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteRequest extends BaseRequest {
    private Long departureAirportId;
    private Long arrivalAirportId;
}
