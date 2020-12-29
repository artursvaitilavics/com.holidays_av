package com.holidays_av.com.holidays_av.entities.company;

import com.holidays_av.com.holidays_av.entities.department.Department;
import com.holidays_av.com.holidays_av.entities.employee.Employee;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(targetEntity = Employee.class,
            mappedBy = "company",
            cascade = CascadeType.MERGE
            , fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
