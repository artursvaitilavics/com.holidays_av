package com.holidays_av.service;

import com.holidays_av.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmployeesService {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Autowired
    public CompanyEmployeesService(
            CompanyService companyService,
            EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }


    public List<Employee> getEmployees(Long id) {
        return companyService.findById(id).getEmployees();
    }

}
