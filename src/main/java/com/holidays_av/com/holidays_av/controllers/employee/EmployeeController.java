package com.holidays_av.com.holidays_av.controllers.employee;

import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import com.holidays_av.com.holidays_av.entities.employee.EmployeeService;
import com.holidays_av.com.holidays_av.entities.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService,
                              CompanyService companyService,
                              DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto.getName(),
                employeeDto.getLastName(),
                companyService.findByName(employeeDto.getCompanyName()).getId(),
                departmentService.findByName(employeeDto.getDepartmentName()).getId()
        );
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


}

