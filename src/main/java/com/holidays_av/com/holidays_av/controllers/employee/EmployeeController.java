package com.holidays_av.com.holidays_av.controllers.employee;

import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import com.holidays_av.com.holidays_av.entities.employee.EmployeeService;
import com.holidays_av.com.holidays_av.entities.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

//    @PostMapping()
//    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
//        return employeeService.createEmployee(
//                employeeDto.getName(),
//                employeeDto.getLastName(),
//                companyService.findByName(employeeDto.getCompanyName()).getId(),
//                departmentService.findByName(employeeDto.getDepartmentName()).getId()
//        );
//    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


//    @GetMapping()
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

    @GetMapping()
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeService.getAllEmployees().forEach(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setLastName(employee.getLastName());


//            TODO: fix below try catch block, looks ridiculous
            try {
                employeeDto.setCompanyName(employee.getCompany().getName());
                employeeDto.setDepartmentName(employee.getDepartment().getName());
            } catch (Exception ex) {
                employeeDto.setCompanyName("Not Set");
                employeeDto.setDepartmentName("Not Set");
            }


            employeeDtoList.add(employeeDto);
        });
        return employeeDtoList;
    }


}

