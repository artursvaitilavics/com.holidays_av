package com.holidays_av.com.holidays_av.entities.employee;

import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final DepartmentService departmentService;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            CompanyService companyService,
            DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @Transactional
    public Employee createEmployee(String name, String lastName, Integer companyId, Integer departmentId) {
        return employeeRepository.save(new Employee(name, lastName, companyService.findById(companyId), departmentService.findById(departmentId)));
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee addDepartment(String name, Integer departmentId) {
        Employee employee = employeeRepository.findByName(name);
        employee.setDepartment(departmentService.findById(departmentId));
        return employee;
    }

    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
