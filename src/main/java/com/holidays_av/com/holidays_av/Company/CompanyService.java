package com.holidays_av.com.holidays_av.Company;

import com.holidays_av.com.holidays_av.department.Department;
import com.holidays_av.com.holidays_av.department.DepartmentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final DepartmentService departmentService;

    public CompanyService(CompanyRepository companyRepository, DepartmentService departmentService) {
        this.companyRepository = companyRepository;
        this.departmentService = departmentService;
    }

    @Transactional
    public void registerCompany(String name) {
        companyRepository.save(new Company(name));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    @Transactional
    public void addDepartment(Company company, Department department) {
        companyRepository.findByName(company.getName()).getDepartments().add(department);
    }

    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    public List<Department> departments(Company company){
        return company.getDepartments();
    }


}
