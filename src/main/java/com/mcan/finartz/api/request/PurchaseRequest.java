package com.mcan.finartz.api.request;

import com.mcan.finartz.persistance.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PurchaseRequest extends BaseRequest {
    private Long flightId;
    private String creditCardNumber;
    private Short purchasedTicketCount;
    private List<String> passengerNames;
    private String billingAddress;
}
