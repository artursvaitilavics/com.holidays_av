package com.holidays_av.com.holidays_av.entities.department;


import com.holidays_av.com.holidays_av.entities.company.Company;
import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import com.holidays_av.com.holidays_av.HolidaysAvApplicationTests;
import com.holidays_av.com.holidays_av.entities.employee.Employee;
import com.holidays_av.com.holidays_av.entities.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentAndCompanyTest extends HolidaysAvApplicationTests {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CompanyService companyService;

    @Autowired
    EmployeeService employeeService;


    @Test
    public void shouldCreateEmployee() {
        companyService.registerCompany("IBM");
        departmentService.createDepartment("HR");
        employeeService.createEmployee(
                "Boby",
                "Tomy",
                companyService.findByName("IBM").getCompany_id(),
                departmentService.findByName("HR").getId());

        employeeService.createEmployee(
                "Lorry",
                "Gonzales",
                companyService.findByName("IBM").getCompany_id(),
                departmentService.findByName("HR").getId());

        String companyName = employeeService.findByName("Boby").getCompany().getName();
        String departmentName = employeeService.findByName("Boby").getDepartment().getName();

        assertEquals("Boby", employeeService.findByName("Boby").getName());
        assertEquals("IBM", companyName);
        assertEquals("HR", departmentName);

        List<String> employeesNames = new ArrayList<>();
        companyService.findByName("IBM").getEmployees().forEach(employee -> {
            employeesNames.add(employee.getName());
        });

        employeesNames.forEach(employee -> {
            System.out.println("Employees Names: " + employee);
        });
        assertEquals("Boby", employeesNames.get(0));

    }

    @Test
    public void shouldGetAllDepartments() {
        departmentService.createDepartment("Finance");
        departmentService.createDepartment("IT");
        departmentService.createDepartment("HR");
        assertEquals(3, departmentService.getAllDepartments().size());
    }

    @Test
    public void shouldGetAllCompanies() {
        companyService.registerCompany("IBM");
        assertEquals("IBM", companyService.findById(1).getName());
    }

    @Test
    public void shouldAddDepartmentToCompany() {

        companyService.registerCompany("Microsoft");
        departmentService.createDepartment("IT");
        departmentService.createDepartment("Finance");


        Company company = companyService.findByName("Microsoft");
        Department department = departmentService.findByName("IT");
        Department department1 = departmentService.findByName("Finance");

        companyService.addDepartment(company.getCompany_id(), department.getId());
        departmentService.addToCompany(company.getCompany_id(), department1.getId());


        assertEquals(2, companyService.findByName("Microsoft").getDepartments().size());


    }

}
