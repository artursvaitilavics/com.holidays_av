package com.holidays_av.com.holidays_av.entities.employee;

import com.holidays_av.com.holidays_av.HolidaysAvApplicationTests;
import com.holidays_av.com.holidays_av.entities.company.CompanyService;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest extends HolidaysAvApplicationTests {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;


}