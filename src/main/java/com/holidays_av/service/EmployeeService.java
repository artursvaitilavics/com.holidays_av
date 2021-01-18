package com.holidays_av.service;

import com.holidays_av.model.employee.Employee;
import com.holidays_av.model.employee.status.EmployeeStatus;
import com.holidays_av.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        employee.setStatus(EmployeeStatus.EMPLOYEE);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Employee employee, Long id) {
        employeeRepository.
                findById(id).
                orElseThrow(()
                        -> new RuntimeException("User by " + id + " not found..."));
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException("User by " + id + " not found..."));
        employee.setStatus(EmployeeStatus.EX_EMPLOYEE);
        employeeRepository.save(employee);
        return employee;
    }
}
