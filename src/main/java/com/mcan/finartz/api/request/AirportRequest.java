package com.mcan.finartz.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportRequest extends BaseRequest {
    private String name;
    private String city;
}
