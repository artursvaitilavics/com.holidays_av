package com.holidays_av.com.holidays_av.controllers.employee;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String lastName;
    private String companyName;
    private String departmentName;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id,
                       String name,
                       String lastName,
                       String companyName,
                       String departmentName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.companyName = companyName;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


