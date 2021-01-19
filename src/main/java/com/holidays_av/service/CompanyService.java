package com.holidays_av.service;

import com.holidays_av.exception.ExceptionService;
import com.holidays_av.exception.utils.ExceptionCode;
import com.holidays_av.model.Company;
import com.holidays_av.model.status.CompanyStatus;
import com.holidays_av.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                () -> exception(id));
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company update(Company company, Long id) {
        companyRepository.findById(id).orElseThrow(() ->
                exception(id));
        company.setId(id);
        return companyRepository.save(company);
    }

    public Company delete(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> exception(id));
        company.setStatus(CompanyStatus.DISABLED);
        return companyRepository.save(company);
    }


    //    helper methods:
    private ExceptionService exception(Long id) {
        return new ExceptionService("Company with id: " + id + " not found...",
                ExceptionCode.CODE_2.name());
    }
}
