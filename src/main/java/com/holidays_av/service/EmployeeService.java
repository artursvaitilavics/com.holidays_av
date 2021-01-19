package com.holidays_av.service;

import com.holidays_av.exception.ExceptionService;
import com.holidays_av.exception.utils.ExceptionCode;
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
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ExceptionService(
                                "Employee with id: " + id + " doesn't exist",
                                ExceptionCode.CODE_1.name())
                );
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
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
}
