package com.mcan.finartz.service.mapper;

import com.mcan.finartz.persistance.entity.BaseEntity;
import com.mcan.finartz.persistance.entity.Purchase;
import com.mcan.finartz.persistance.entity.Ticket;
import com.mcan.finartz.service.dto.PurchaseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class PurchaseServiceMapper implements BaseServiceMapper<PurchaseDto, Purchase> {
    @AfterMapping
    public void setTicketsIds(Purchase purchase, @MappingTarget PurchaseDto purchaseDto) {
        if (purchase.getTickets() != null) {
            purchaseDto.setTicketIds(purchase.getTickets().stream().map(Ticket::getId).collect(Collectors.toList()));
        }
    }
}
