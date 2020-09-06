package com.mcan.finartz.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportResponse extends BaseResponse {
    private String name;
    private String city;
}
