package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.Flight;
import com.mcan.finartz.service.dto.FlightDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightServiceMapper extends BaseServiceMapper<FlightDto, Flight> {
}
