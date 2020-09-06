package com.mcan.finartz.service.impl;

import com.mcan.finartz.persistance.entity.Airport;
import com.mcan.finartz.persistance.repository.AirportRepository;
import com.mcan.finartz.service.AirportService;
import com.mcan.finartz.service.dto.AirportDto;
import com.mcan.finartz.service.mapper.AirportServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl extends BaseServiceImpl<AirportDto, Airport, AirportRepository, AirportServiceMapper> implements AirportService {

    public AirportServiceImpl(AirportRepository airportRepository, AirportServiceMapper airportMapper) {
        super(airportRepository, airportMapper);
    }

    @Override
    protected Airport updateFields(Airport l, AirportDto airportDto) {
        if (airportDto.getCity() != null) {
            l.setCity(airportDto.getCity());
        }
        if (airportDto.getName() != null) {
            l.setName(airportDto.getName());
        }
        return l;
    }
}
