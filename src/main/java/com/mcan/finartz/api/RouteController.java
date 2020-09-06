package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.RouteApiMapper;
import com.mcan.finartz.api.request.RouteRequest;
import com.mcan.finartz.api.response.RouteResponse;
import com.mcan.finartz.service.RouteService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Route Controller")
@RestController
@RequestMapping("/route")
public class RouteController extends BaseController<RouteService, RouteApiMapper, RouteResponse, RouteRequest> {
    public RouteController(RouteService service, RouteApiMapper mapper) {
        super(service, mapper);
    }
}
