package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.AirportApiMapper;
import com.mcan.finartz.api.request.AirportRequest;
import com.mcan.finartz.api.response.AirportResponse;
import com.mcan.finartz.service.AirportService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Airport Controller")
@RestController
@RequestMapping("/airport")
public class AirportController extends BaseController<AirportService, AirportApiMapper, AirportResponse, AirportRequest> {

    public AirportController(AirportService service, AirportApiMapper mapper) {
        super(service, mapper);
    }
}
