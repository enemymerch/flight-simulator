package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.FlightApiMapper;
import com.mcan.finartz.api.request.FlightRequest;
import com.mcan.finartz.api.response.FlightResponse;
import com.mcan.finartz.service.FlightService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Flight Controller")
@RestController
@RequestMapping("/flight")
public class FlightController extends BaseController<FlightService, FlightApiMapper, FlightResponse, FlightRequest>{
    public FlightController(FlightService service, FlightApiMapper mapper) {
        super(service, mapper);
    }
}
