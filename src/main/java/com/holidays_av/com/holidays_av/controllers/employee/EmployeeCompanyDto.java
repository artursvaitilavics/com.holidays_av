package com.holidays_av.com.holidays_av.controllers.employee;

public class EmployeeCompanyDto {
    private Integer id;
    private Integer companyId;

    public EmployeeCompanyDto() {
    }

    public EmployeeCompanyDto(Integer id, Integer companyId) {
        this.id = id;
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
