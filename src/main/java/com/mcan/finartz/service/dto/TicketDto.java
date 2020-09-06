package com.mcan.finartz.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto extends BaseDto {
    private FlightDto flight;
    private String passenger;
    private PurchaseDto purchase;
}
