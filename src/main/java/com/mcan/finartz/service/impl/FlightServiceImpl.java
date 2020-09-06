package com.mcan.finartz.service.impl;

import com.mcan.finartz.persistance.entity.Flight;
import com.mcan.finartz.persistance.repository.FlightRepository;
import com.mcan.finartz.service.FlightService;
import com.mcan.finartz.service.dto.FlightDto;
import com.mcan.finartz.service.mapper.FlightServiceMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FlightServiceImpl extends BaseServiceImpl<FlightDto, Flight, FlightRepository, FlightServiceMapper> implements FlightService {
    public FlightServiceImpl(FlightRepository flightRepository, FlightServiceMapper flightServiceMapper) {
        super(flightRepository, flightServiceMapper);
    }

    @Override
    protected Flight updateFields(Flight l, FlightDto flightDto) {
        if (flightDto.getDepartureDate() != null) {
            l.setDepartureDate(flightDto.getDepartureDate());
        }
        if (flightDto.getArrivalDate() != null) {
            l.setArrivalDate(flightDto.getArrivalDate());
        }
        if (flightDto.getPassengerCapacity() != null) {
            Integer capacityDifference = flightDto.getPassengerCapacity()-l.getPassengerCapacity();
            Integer tenPercentOfCurrentCapacity = l.getPassengerCapacity()/10;
            if (capacityDifference > tenPercentOfCurrentCapacity) {
                BigDecimal currentPrice = l.getTicketPrice();
                l.setTicketPrice(currentPrice.multiply(new BigDecimal(1.1)));
            }
            l.setPassengerCapacity(flightDto.getPassengerCapacity());
        }
        return l;
    }
}
