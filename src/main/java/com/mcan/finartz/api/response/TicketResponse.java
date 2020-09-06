package com.mcan.finartz.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketResponse extends BaseResponse {
    private FlightResponse flight;
    private String passenger;
}
