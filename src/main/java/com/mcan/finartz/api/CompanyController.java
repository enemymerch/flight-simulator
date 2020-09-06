package com.mcan.finartz.api;

import com.mcan.finartz.api.mapper.CompanyApiMapper;
import com.mcan.finartz.api.request.CompanyRequest;
import com.mcan.finartz.api.response.CompanyResponse;
import com.mcan.finartz.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Company Controller")
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController<CompanyService, CompanyApiMapper, CompanyResponse, CompanyRequest> {
    public CompanyController(CompanyService service, CompanyApiMapper mapper) {
        super(service, mapper);
    }
}
