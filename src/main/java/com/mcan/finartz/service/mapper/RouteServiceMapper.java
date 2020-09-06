package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.Route;
import com.mcan.finartz.service.dto.RouteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteServiceMapper extends BaseServiceMapper<RouteDto, Route> {
}
