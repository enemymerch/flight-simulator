package com.mcan.finartz.service.impl;

import com.mcan.finartz.persistance.entity.Company;
import com.mcan.finartz.persistance.repository.CompanyRepository;
import com.mcan.finartz.service.CompanyService;
import com.mcan.finartz.service.dto.CompanyDto;
import com.mcan.finartz.service.mapper.CompanyServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyDto, Company, CompanyRepository, CompanyServiceMapper> implements CompanyService {

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyServiceMapper companyMapper) {
        super(companyRepository, companyMapper);
    }

    @Override
    protected Company updateFields(Company l, CompanyDto companyDto) {
        l.setName(companyDto.getName());
        return l;
    }
}
