package com.holidays_av.controller;

import com.holidays_av.dto.EmployeeDto;
import com.holidays_av.mapper.EmployeeMapper;
import com.holidays_av.model.Employee;
import com.holidays_av.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/api/Employee.svc")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeDto employeeDto = new EmployeeDto();

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/employee")
    public EmployeeDto save(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.fromDto(employeeDto);
        Employee savedEmployee = employeeService.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeService.findAll();
        return employees.stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("/employee({id})")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto,
                              @PathVariable("id") Long id) {
        Employee employee = employeeService.update(employeeMapper.fromDto(employeeDto), id);
        return employeeMapper.toDto(employee);
    }

    @DeleteMapping("/employee({id})")
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }


}
