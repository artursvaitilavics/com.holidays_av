package com.holidays_av.mapper;


import com.holidays_av.dto.CompanyDto;
import com.holidays_av.model.Company;
import com.holidays_av.model.status.CompanyStatus;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    private CompanyDto toDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setStatus(company.getStatus().name());
        return companyDto;
    }

    private Company fromDto(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setStatus(CompanyStatus.valueOf(companyDto.getStatus()));
        return company;
    }

}
