package com.holidays_av.mapper;

import com.holidays_av.dto.CompanyDto;
import com.holidays_av.model.Company;
import com.holidays_av.model.status.CompanyStatus;
import org.junit.Test;

import static org.aspectj.runtime.internal.Conversions.longValue;
import static org.junit.Assert.assertEquals;

public class CompanyMapperTest {

    private CompanyMapper companyMapper = new CompanyMapper();

    @Test
    public void toDto(){
        Company company = new Company();
        company.setId(1L);
        company.setName("IBM");
        company.setStatus(CompanyStatus.ACTIVE);

        CompanyDto companyDto = companyMapper.toDto(company);

        assertEquals(longValue(1), longValue(companyDto.getId()));
        assertEquals("IBM", companyDto.getName());
        assertEquals("ACTIVE", companyDto.getStatus());

    }

    @Test
    public void fromDto(){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("IBM");
        companyDto.setStatus("ACTIVE");

        Company company = companyMapper.fromDto(companyDto);

        assertEquals("IBM", company.getName());
        assertEquals("ACTIVE", company.getStatus().name());

    }


}
