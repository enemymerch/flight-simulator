package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.PurchaseRequest;
import com.mcan.finartz.api.response.PurchaseResponse;
import com.mcan.finartz.api.response.TicketResponse;
import com.mcan.finartz.service.TicketService;
import com.mcan.finartz.service.dto.PurchaseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PurchaseApiMapper implements BaseApiMapper<PurchaseDto, PurchaseRequest, PurchaseResponse> {

    @Autowired
    private TicketApiMapper ticketApiMapper;
    @Autowired
    private TicketService ticketService;

    @AfterMapping
    public void fetchTickets(PurchaseDto purchaseDto, @MappingTarget PurchaseResponse purchaseResponse) {
        try {
            List<TicketResponse> ticketResponseList = new ArrayList<>();
            if (purchaseDto.getTicketIds() != null) {
                for (Long ticketId : purchaseDto.getTicketIds()) {
                    ticketResponseList.add(ticketApiMapper.dtoToResponse(ticketService.getById(ticketId)));
                }
                purchaseResponse.setTickets(ticketResponseList);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
