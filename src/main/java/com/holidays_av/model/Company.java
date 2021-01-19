package com.holidays_av.model;


import com.holidays_av.model.status.CompanyStatus;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company extends BasicModel {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    public CompanyStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyStatus status) {
        this.status = status;
    }

}
