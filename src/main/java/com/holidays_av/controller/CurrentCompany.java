package com.holidays_av.controller;

import com.holidays_av.dto.EmployeeDto;
import com.holidays_av.mapper.EmployeeMapper;
import com.holidays_av.service.CompanyEmployeesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/api/CurrentCompany.svc")
@CrossOrigin("*")
public class CurrentCompany {

    private final CompanyEmployeesService companyEmployeesService;
    private final EmployeeMapper employeeMapper;

    public CurrentCompany(CompanyEmployeesService companyEmployeesService,
                          EmployeeMapper employeeMapper) {
        this.companyEmployeesService = companyEmployeesService;
        this.employeeMapper = employeeMapper;
    }


    @GetMapping("/company({id})")
    public List<EmployeeDto> getEmployees(@PathVariable("id") Long id) {
        return companyEmployeesService
                .getEmployees(id)
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
}
