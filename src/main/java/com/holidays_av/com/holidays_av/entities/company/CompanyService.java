package com.holidays_av.com.holidays_av.entities.company;

import com.holidays_av.com.holidays_av.entities.department.Department;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    public Company findById(Integer id) {
        return companyRepository.getOne(id);
    }

    @Transactional
    public void addDepartment(Integer companyId, Integer departmentId) {
        Company company = companyRepository.getOne(companyId);
        Department department = departmentService.findById(departmentId);
        department.setCompany(company);
        company.getDepartments().add(department);

    }

    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    public List<Department> departments(Company company) {
        return company.getDepartments();
    }


}
