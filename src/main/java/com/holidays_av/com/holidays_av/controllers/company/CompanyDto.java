package com.holidays_av.com.holidays_av.controllers.company;

import java.util.List;

public class CompanyDto {
    private Integer id;
    private String name;
    private List<String> departments;
//    TODO: field for employees;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompanyDto() {
    }

    public CompanyDto(Integer id, String name, List<String> departments) {
        this.id = id;
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
