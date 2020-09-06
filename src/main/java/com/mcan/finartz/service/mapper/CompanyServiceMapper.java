package com.mcan.finartz.service.mapper;

import com.mcan.finartz.api.request.CompanyRequest;
import com.mcan.finartz.api.response.CompanyResponse;
import com.mcan.finartz.persistance.entity.Company;
import com.mcan.finartz.service.dto.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyServiceMapper extends BaseServiceMapper<CompanyDto, Company> {
}
