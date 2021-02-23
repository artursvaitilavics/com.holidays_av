package com.holidays_av.service;

import com.holidays_av.exception.ExceptionService;
import com.holidays_av.exception.utils.ExceptionCode;
import com.holidays_av.model.Employee;
import com.holidays_av.model.status.EmployeeStatus;
import com.holidays_av.repository.EmployeeRepository;
import com.holidays_av.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeValidator employeeValidator;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeValidator employeeValidator) {
        this.employeeRepository = employeeRepository;
        this.employeeValidator = employeeValidator;
    }

    public Employee save(Employee employee) {

        employee.setStatus(EmployeeStatus.EMPLOYEE);

        employee.setDayLeft(25);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ExceptionService(
                                "Employee with id: " + id + " doesn't exist",
                                ExceptionCode.CODE_1.name())
                );
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> {
            if(employeeValidator.isEmployee(employee)){
                employees.add(employee);
            }
        });

        return employees;

    }

    public Employee update(Employee employee, Long id) {
        employeeRepository.
                findById(id).orElseThrow(
                () -> new ExceptionService(
                        "Employee with id: " + id + " doesn't exist",
                        ExceptionCode.CODE_1.name())
        );
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ExceptionService(
                        "Employee with id: " + id + " doesn't exist",
                        ExceptionCode.CODE_1.name())
        );
        employee.setStatus(EmployeeStatus.EX_EMPLOYEE);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
