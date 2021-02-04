package com.holidays_av.service;

import com.holidays_av.model.Company;
import com.holidays_av.model.status.CompanyStatus;
import com.holidays_av.repository.CompanyRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;
import static org.junit.Assert.assertEquals;

public class CompanyServiceTest {

    public CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
    public CompanyService companyService = new CompanyService(companyRepository);


    @Test
    public void save() {
        Company company =
                createCompany(1L, "IBM", CompanyStatus.ACTIVE);

        Mockito.when(companyRepository.save(company)).thenReturn(company);

        Company result = companyService.save(company);

        assertEquals(1L, longValue(result.getId()));
        assertEquals("IBM", result.getName());
        assertEquals(CompanyStatus.ACTIVE, result.getStatus());

    }

    @Test
    public void findById() {
        Company company =
                createCompany(1L, "IBM", CompanyStatus.ACTIVE);

        Mockito.when(companyRepository.findById(1L)).thenReturn(java.util.Optional.of(company));

        Company result = companyService.findById(1L);

        assertEquals(1L, longValue(result.getId()));
        assertEquals("IBM", result.getName());
        assertEquals(CompanyStatus.ACTIVE, result.getStatus());

    }

    @Test
    public void findAll() {
        Company company01 =
                createCompany(1L, "IBM", CompanyStatus.ACTIVE);
        Company company02 =
                createCompany(2L, "NOSTROMO", CompanyStatus.ACTIVE);
        Company company03 =
                createCompany(3L, "SkyNET", CompanyStatus.ACTIVE);

        List<Company> companies = new ArrayList<>();
        companies.add(company01);
        companies.add(company02);
        companies.add(company03);

        Mockito.when(companyRepository.findAll()).thenReturn(companies);

        List<Company> resultList = companyService.findAll();

        assertEquals(3, resultList.size());

        String resultName001 = "";
        String resultName002 = "";
        String resultName003 = "";

        for (Company company : resultList) {
            if (company.getName().equals("IBM")) {
                resultName001 = company.getName();
            }
            if (company.getName().equals("NOSTROMO")) {
                resultName002 = company.getName();
            }
            if (company.getName().equals("SkyNET")) {
                resultName003 = company.getName();
            }
        }

        assertEquals("IBM", resultName001);
        assertEquals("NOSTROMO", resultName002);
        assertEquals("SkyNET", resultName003);

    }

    @Test
    public void update() {
        Company company = createCompany(1L, "Alias", CompanyStatus.DISABLED);

        Company updatedCompany = new Company();
        updatedCompany.setName("Autodesk");
        updatedCompany.setStatus(CompanyStatus.ACTIVE);

        Mockito.when(companyRepository.findById(1L)).thenReturn(java.util.Optional.of(company));

        Mockito.when(companyRepository.save(updatedCompany)).thenReturn(updatedCompany);

        Company result = companyService.update(updatedCompany, 1L);

        assertEquals(1L, longValue(result.getId()));
        assertEquals("Autodesk", result.getName());
        assertEquals(CompanyStatus.ACTIVE, result.getStatus());

    }

    @Test
    public void delete() {
        Company company = createCompany(1L, "Alias", CompanyStatus.ACTIVE);

        Mockito.when(companyRepository.findById(1L)).thenReturn(java.util.Optional.of(company));
        Mockito.when(companyRepository.save(company)).thenReturn(company);

        Company result = companyService.delete(1L);

        assertEquals(1L, longValue(result.getId()));
        assertEquals("Alias", result.getName());
        assertEquals(CompanyStatus.DISABLED, result.getStatus());
    }


    private Company createCompany(
            Long id,
            String name,
            CompanyStatus companyStatus) {

        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setStatus(companyStatus);

        return company;
    }
}