package com.holidays_av.com.holidays_av.Company;

import com.holidays_av.com.holidays_av.department.Department;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Department.class,
            mappedBy = "company",
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
//    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private List<Department> departments = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Integer getCompany_id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }
}
