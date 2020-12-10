package com.holidays_av.com.holidays_av.controllers.department;


import com.holidays_av.com.holidays_av.entities.company.Company;
import com.holidays_av.com.holidays_av.entities.department.Department;
import com.holidays_av.com.holidays_av.entities.department.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
//@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //    TODO: Create DTO Class for Company


    @GetMapping()
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PatchMapping()
    public void addToCompany(@RequestBody CompanyToDepartmentBd companyToDepartmentBd){
        departmentService.addToCompany(companyToDepartmentBd.getCompanyId(), companyToDepartmentBd.getDepartmentId());
    }

}
