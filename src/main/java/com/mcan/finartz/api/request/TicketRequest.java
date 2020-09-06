package com.mcan.finartz.api.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketRequest extends BaseRequest {
    private Long flightId;
    private String passenger;
}
