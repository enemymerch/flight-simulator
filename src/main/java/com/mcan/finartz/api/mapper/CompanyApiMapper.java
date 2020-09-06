package com.mcan.finartz.api.mapper;

import com.mcan.finartz.api.request.CompanyRequest;
import com.mcan.finartz.api.response.CompanyResponse;
import com.mcan.finartz.service.dto.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyApiMapper extends BaseApiMapper<CompanyDto, CompanyRequest, CompanyResponse>{
}
