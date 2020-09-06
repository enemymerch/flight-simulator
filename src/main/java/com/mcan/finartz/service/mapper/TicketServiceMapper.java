package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.Ticket;
import com.mcan.finartz.service.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketServiceMapper extends BaseServiceMapper<TicketDto, Ticket> {
}
