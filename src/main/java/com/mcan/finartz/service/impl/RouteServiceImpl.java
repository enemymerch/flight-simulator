package com.mcan.finartz.service.impl;

import com.mcan.finartz.persistance.entity.Route;
import com.mcan.finartz.persistance.repository.RouteRepository;
import com.mcan.finartz.service.RouteService;
import com.mcan.finartz.service.dto.RouteDto;
import com.mcan.finartz.service.mapper.RouteServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl extends BaseServiceImpl<RouteDto, Route, RouteRepository, RouteServiceMapper> implements RouteService {

    public RouteServiceImpl(RouteRepository routeRepository, RouteServiceMapper routeServiceMapper) {
        super(routeRepository, routeServiceMapper);
    }

    @Override
    protected Route updateFields(Route l, RouteDto routeDto) {
        // don't update routes, that's just rude
        return l;
    }
}
