package com.mcan.finartz.service.impl;

import com.mcan.finartz.persistance.entity.Ticket;
import com.mcan.finartz.persistance.repository.TicketRepository;
import com.mcan.finartz.service.TicketService;
import com.mcan.finartz.service.dto.TicketDto;
import com.mcan.finartz.service.mapper.TicketServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<TicketDto, Ticket, TicketRepository, TicketServiceMapper> implements TicketService {
    public TicketServiceImpl(TicketRepository ticketRepository, TicketServiceMapper ticketServiceMapper) {
        super(ticketRepository, ticketServiceMapper);
    }

    @Override
    protected Ticket updateFields(Ticket l, TicketDto ticketDto) {
        // can only update passenger name
        l.setPassenger(ticketDto.getPassenger());
        return l;
    }
}
