package com.mcan.finartz.api;


import com.mcan.finartz.api.mapper.PurchaseApiMapper;
import com.mcan.finartz.api.mapper.TicketApiMapper;
import com.mcan.finartz.api.request.PurchaseRequest;
import com.mcan.finartz.api.response.PurchaseResponse;
import com.mcan.finartz.api.response.TicketResponse;
import com.mcan.finartz.service.PurchaseService;
import com.mcan.finartz.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "Purchase Controller")
@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {

    private PurchaseService purchaseService;
    private TicketService ticketService;
    private PurchaseApiMapper purchaseApiMapper;
    private TicketApiMapper ticketApiMapper;

    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseResponse> getById(@Validated @PathVariable Long purchaseId) throws Throwable {
        return new ResponseEntity<>(purchaseApiMapper.dtoToResponse(purchaseService.getById(purchaseId)), HttpStatus.OK);
    }

    @ApiOperation(value = "purchases a given number of tickets", notes = "you need to enter the passengerNames according to your purchasedTickedNumber or expect an exception")
    @PostMapping
    public ResponseEntity<PurchaseResponse> doPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        return new ResponseEntity<>(purchaseApiMapper.dtoToResponse(purchaseService.purchase(purchaseApiMapper.requestToDto(purchaseRequest))), HttpStatus.OK);
    }

    @DeleteMapping("/purchaseId")
    public ResponseEntity<?> cancelPurchase(@Validated @PathVariable Long purchaseId) {
        purchaseService.cancelPurchase(purchaseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ticket-info/{ticketID}")
    public ResponseEntity<TicketResponse> getTicketInfoByTicketId(@Validated @PathVariable Long ticketId) throws Throwable {
        return new ResponseEntity<>(ticketApiMapper.dtoToResponse(ticketService.getById(ticketId)), HttpStatus.OK);
    }
}
