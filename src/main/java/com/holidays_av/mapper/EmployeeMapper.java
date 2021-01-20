package com.holidays_av.mapper;

import com.holidays_av.dto.EmployeeDto;
import com.holidays_av.model.Employee;
import com.holidays_av.model.status.EmployeeStatus;
import com.holidays_av.service.CompanyService;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final CompanyService companyService;

    public EmployeeMapper(CompanyService companyService) {
        this.companyService = companyService;
    }


    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setStatus(employee.getStatus().name());
        employeeDto.setCompanyId(employee.getCompany().getId());
        return employeeDto;
    }

    public Employee fromDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setStatus(EmployeeStatus.valueOf(employeeDto.getStatus()));
        employee.setCompany(companyService.findById(employeeDto.getCompanyId())); // I have a bad feeling about this
        return employee;
    }
}
