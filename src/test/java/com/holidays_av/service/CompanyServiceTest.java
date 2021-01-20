package com.holidays_av.service;

import com.holidays_av.model.Company;
import com.holidays_av.model.Employee;
import com.holidays_av.model.status.CompanyStatus;
import com.holidays_av.model.status.EmployeeStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

class CompanyServiceTest {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Autowired
    CompanyServiceTest(CompanyService companyService,
                       EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @Test
    void save() {
        Company company = new Company();
        company.setName("Wizardry INC");
        company.setStatus(CompanyStatus.ACTIVE);
        companyService.save(company);


        Employee employee = new Employee();
        employee.setName("Gandalf");
        employee.setLastName("Mithrandir");
        employee.setEmail("gandalf.mithrandir@middle-earth.com");
        employee.setStatus(EmployeeStatus.ADMIN);
        employeeService.save(employee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        company.setEmployees(employees);




    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}