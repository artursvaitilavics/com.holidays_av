package com.holidays_av.com.holidays_av.entities.department;

import com.holidays_av.com.holidays_av.entities.company.Company;
import com.holidays_av.com.holidays_av.entities.company.CompanyRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;


    public DepartmentService(DepartmentRepository departmentRepository, CompanyRepository companyRepository) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public Department createDepartment(String name) {
        return departmentRepository.save(new Department(name));
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    public Department findById(Integer departmentId) {
        return departmentRepository.getOne(departmentId);
    }

    @Transactional
    public void addToCompany(Integer companyId, Integer departmentId) {
        Company company = companyRepository.getOne(companyId);
        Department department = departmentRepository.getOne(departmentId);
        company.getDepartments().add(department);
        department.setCompany(company);
        departmentRepository.save(department);
    }

    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
