package com.holidays_av.mapper;

import com.holidays_av.dto.EmployeeDto;
import com.holidays_av.model.employee.Employee;
import com.holidays_av.model.employee.status.EmployeeStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setStatus(employee.getStatus().name());
        return employeeDto;
    }

    public Employee fromDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setStatus(EmployeeStatus.valueOf(employeeDto.getStatus()));
        return employee;
    }
}
