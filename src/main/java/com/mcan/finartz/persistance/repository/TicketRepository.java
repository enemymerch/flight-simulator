package com.mcan.finartz.persistance.repository;

import com.mcan.finartz.persistance.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket> {
    List<Ticket> findByFlightId(Long flightId);
}
