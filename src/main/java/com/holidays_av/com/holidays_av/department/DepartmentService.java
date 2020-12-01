package com.holidays_av.com.holidays_av.department;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Department createDepartment(String name) {
        return departmentRepository.save(new Department(name));
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    public Department findByName(String name){
        return departmentRepository.findByName(name);
    }

}
