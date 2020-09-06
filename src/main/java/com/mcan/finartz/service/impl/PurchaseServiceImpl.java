package com.mcan.finartz.service.impl;

import com.mcan.finartz.exception.DataNotFoundException;
import com.mcan.finartz.persistance.entity.Flight;
import com.mcan.finartz.persistance.entity.Purchase;
import com.mcan.finartz.persistance.entity.Ticket;
import com.mcan.finartz.persistance.repository.PurchaseRepository;
import com.mcan.finartz.persistance.repository.TicketRepository;
import com.mcan.finartz.service.FlightService;
import com.mcan.finartz.service.PurchaseService;
import com.mcan.finartz.service.TicketService;
import com.mcan.finartz.service.dto.FlightDto;
import com.mcan.finartz.service.dto.PurchaseDto;
import com.mcan.finartz.service.dto.TicketDto;
import com.mcan.finartz.service.mapper.PurchaseServiceMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Setter
public class PurchaseServiceImpl extends BaseServiceImpl<PurchaseDto, Purchase, PurchaseRepository, PurchaseServiceMapper> implements PurchaseService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PurchaseServiceMapper purchaseServiceMapper;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private FlightService flightService;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseServiceMapper purchaseServiceMapper) {
        super(purchaseRepository, purchaseServiceMapper);
    }

    public String fixCreditCardNumber(String creditCardNumber) {
        return creditCardNumber.replace("-",  "");
    }

    @Override
    @Transactional
    public PurchaseDto create(PurchaseDto purchaseDto) {
        PurchaseDto createdPurchaseDto = new PurchaseDto();
        if (purchaseDto != null) {
            try {
                //getting flight and setting cost of purchase
                FlightDto flightDto = flightService.getById(purchaseDto.getFlightId());
                Flight flight = new Flight();
                flight.setId(flightDto.getId());
                Purchase purchase = purchaseServiceMapper.dtoToEntity(purchaseDto);
                BigDecimal cost = flightDto.getTicketPrice().multiply(new BigDecimal(purchaseDto.getPurchasedTicketCount()));
                purchase.setCost(cost);

                // checking creditcardnumberOrtadan Kaybolan Bir Uçak
                String fixedNumber = fixCreditCardNumber(purchaseDto.getCreditCardNumber());
                if (fixedNumber.length() != 16) {
                    throw new IllegalArgumentException();
                }
                purchase.setCreditCardNumber(fixedNumber);

                purchase = purchaseRepository.save(purchase);
                // creating tickets
                for (int i = 0; i < purchaseDto.getPurchasedTicketCount(); i++){
                    Ticket ticket = new Ticket();
                    ticket.setFlight(flight);
                    ticket.setPurchase(purchase);
                    ticket.setPassenger(purchaseDto.getPassengerNames().get(i));
                    ticketRepository.save(ticket);
                }
                createdPurchaseDto = this.getById(purchase.getId());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return createdPurchaseDto;
    }

    @Override
    protected Purchase updateFields(Purchase l, PurchaseDto purchaseDto) {
        return l;
    }

    @Override
    public PurchaseDto update(Long id, PurchaseDto purchaseDto) throws Throwable {
        // no updates on purchase !
        return purchaseDto;
    }

    @Override
    public PurchaseDto purchase(PurchaseDto purchaseDto) {
        return this.create(purchaseDto);
    }

    @Override
    public void cancelPurchase(Long id) {
        this.delete(id);
    }
}
