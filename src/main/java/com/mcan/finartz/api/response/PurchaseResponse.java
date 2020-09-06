package com.mcan.finartz.api.response;

import com.mcan.finartz.service.dto.TicketDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PurchaseResponse extends BaseResponse{
    private List<TicketResponse> tickets;
    private String creditCardNumber;
    private Short purchasedTicketCount;
    private BigDecimal cost;
    private String billingAddress;
}
