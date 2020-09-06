package com.mcan.finartz.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PurchaseDto extends BaseDto {
    private Long flightId;
    private String creditCardNumber;
    private Short purchasedTicketCount;
    private BigDecimal cost;
    private String billingAddress;
    private List<Long> ticketIds;
    private List<String> passengerNames;
}
