package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.FlightRequest;
import com.mcan.finartz.api.response.FlightResponse;
import com.mcan.finartz.service.CompanyService;
import com.mcan.finartz.service.RouteService;
import com.mcan.finartz.service.dto.CompanyDto;
import com.mcan.finartz.service.dto.FlightDto;
import com.mcan.finartz.service.dto.RouteDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FlightApiMapper implements BaseApiMapper<FlightDto, FlightRequest, FlightResponse> {

    @Autowired
    private RouteService routeService;

    @Autowired
    private CompanyService companyService;


    @AfterMapping
    public void fetchCompanyAndRoute(FlightRequest flightRequest,  @MappingTarget FlightDto flightDto) {
        try {
            RouteDto routeDto = routeService.getById(flightRequest.getRouteId());
            CompanyDto companyDto = companyService.getById(flightRequest.getCompanyId());
            flightDto.setRoute(routeDto);
            flightDto.setCompany(companyDto);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
