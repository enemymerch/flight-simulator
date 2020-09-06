package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.AirportRequest;
import com.mcan.finartz.api.response.AirportResponse;
import com.mcan.finartz.service.dto.AirportDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportApiMapper extends BaseApiMapper<AirportDto, AirportRequest, AirportResponse> {
}
