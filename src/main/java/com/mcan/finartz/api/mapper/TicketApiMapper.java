package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.TicketRequest;
import com.mcan.finartz.api.response.TicketResponse;
import com.mcan.finartz.service.FlightService;
import com.mcan.finartz.service.dto.FlightDto;
import com.mcan.finartz.service.dto.TicketDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TicketApiMapper implements BaseApiMapper<TicketDto, TicketRequest, TicketResponse> {

    @Autowired
    private FlightService flightService;

    @AfterMapping
    public void fetchFlight(TicketRequest ticketRequest, @MappingTarget TicketDto ticketDto) {
        try {
            FlightDto flightDto = flightService.getById(ticketRequest.getFlightId());
            ticketDto.setFlight(flightDto);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
