package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.Airport;
import com.mcan.finartz.service.dto.AirportDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportServiceMapper extends BaseServiceMapper<AirportDto, Airport> {
}
