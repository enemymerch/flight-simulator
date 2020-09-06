package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.RouteRequest;
import com.mcan.finartz.api.response.RouteResponse;
import com.mcan.finartz.service.AirportService;
import com.mcan.finartz.service.dto.AirportDto;
import com.mcan.finartz.service.dto.RouteDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class RouteApiMapper implements BaseApiMapper<RouteDto, RouteRequest, RouteResponse> {
    @Autowired
    private AirportService airportService;

    @AfterMapping
    public void fetchAirports(RouteRequest routeRequest, @MappingTarget RouteDto routeDto){
        try {
            AirportDto departureAirport = airportService.getById(routeRequest.getDepartureAirportId());
            AirportDto arrivalAirport = airportService.getById(routeRequest.getArrivalAirportId());
            routeDto.setDepartureAirport(departureAirport);
            routeDto.setArrivalAirport(arrivalAirport);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
