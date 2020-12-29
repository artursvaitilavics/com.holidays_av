package com.holidays_av.com.holidays_av.entities.department;

import com.holidays_av.com.holidays_av.entities.company.Company;
import com.holidays_av.com.holidays_av.entities.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true, referencedColumnName = "id")
    private Company company;

    @OneToMany(targetEntity = Employee.class,
            mappedBy = "department",
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
