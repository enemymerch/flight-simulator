package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.TicketApiMapper;
import com.mcan.finartz.api.request.TicketRequest;
import com.mcan.finartz.api.response.TicketResponse;
import com.mcan.finartz.service.TicketService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Ticket Controller")
@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController<TicketService, TicketApiMapper, TicketResponse, TicketRequest> {
    public TicketController(TicketService service, TicketApiMapper mapper) {
        super(service, mapper);
    }
}

//
//public class TicketController {
//}