package com.holidays_av.model;

import com.holidays_av.model.status.EmployeeStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends BasicModel {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatus status;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "employee")//faren key in holday table
    private List<Holiday> holiday;

    @Column(name = "days_left")
    private Integer dayLeft;

    public List<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(List<Holiday> holiday) {
        this.holiday = holiday;
    }

    public Integer getDayLeft() {
        return dayLeft;
    }

    public void setDayLeft(Integer dayLeft) {
        this.dayLeft = dayLeft;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
