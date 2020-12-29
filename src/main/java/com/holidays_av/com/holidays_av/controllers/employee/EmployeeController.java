package com.holidays_av.com.holidays_av.controllers.employee;

import com.holidays_av.com.holidays_av.entities.employee.EmployeeService;
import com.holidays_av.com.holidays_av.entities.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
