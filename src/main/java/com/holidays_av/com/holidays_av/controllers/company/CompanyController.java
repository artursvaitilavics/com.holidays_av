package com.holidays_av.com.holidays_av.controllers.company;

import com.holidays_av.com.holidays_av.entities.company.Company;
import com.holidays_av.com.holidays_av.entities.company.CompanyRepository;
import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
//@CrossOrigin(origins = "http://localhost:4200")

public class CompanyController {
    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

//    TODO: Create DTO Class for Company

    public CompanyController(CompanyService companyService, CompanyRepository companyRepository) {
        this.companyService = companyService;
        this.companyRepository = companyRepository;
    }

    @GetMapping()
    public List<CompanyDto> getCompanies() {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        companyService.getAllCompanies().forEach(company -> {
            CompanyDto companyDto = new CompanyDto();
            List<String> departmentNames = new ArrayList<String>();
            companyDto.setId(company.getId());
            companyDto.setName(company.getName());
            company.getDepartments().forEach(department -> {
                departmentNames.add(department.getName());
            });
            companyDto.setDepartments(departmentNames);
            companyDtoList.add(companyDto);
        });
        return companyDtoList;
    }

    @PostMapping()
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }
}
