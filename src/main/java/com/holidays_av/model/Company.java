package com.holidays_av.model;


import com.holidays_av.model.status.CompanyStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company extends BasicModel {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    @OneToMany(mappedBy = "company")// refers to column in employees table
    private List<Employee> employees;

    public CompanyStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyStatus status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
