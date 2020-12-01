package com.holidays_av.com.holidays_av.department;


import com.holidays_av.com.holidays_av.company.Company;
import com.holidays_av.com.holidays_av.company.CompanyService;
import com.holidays_av.com.holidays_av.HolidaysAvApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentAndCompanyTest extends HolidaysAvApplicationTests {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CompanyService companyService;


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
        assertEquals("IBM", companyService.findById(1).get().getName());
    }

    @Test
    public void shouldAddDepartmentToCompany() {

        companyService.registerCompany("Microsoft");
        departmentService.createDepartment("IT");


        Company company = companyService.findByName("Microsoft");
        Department department = departmentService.findByName("IT");

        companyService.addDepartment(company, department);

        System.out.println(companyService.findByName("Microsoft").getName());

        assertEquals(1, companyService.findByName("Microsoft").getDepartments().size());


    }

}
