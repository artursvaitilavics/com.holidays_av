package com.holidays_av.com.holidays_av.controllers.department;

public class CompanyToDepartmentBd {
    private Integer companyId;
    private Integer departmentId;

    public CompanyToDepartmentBd(Integer companyId, Integer departmentId) {
        this.companyId = companyId;
        this.departmentId = departmentId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
