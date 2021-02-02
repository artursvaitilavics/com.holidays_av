package com.holidays_av.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto extends BasicDto {

    @NotEmpty(message = "Please check lastname")
    @JsonProperty("last_name")
    private String lastName;

    @Email(message = "Please check email")
    @JsonProperty("email")
    private String email;

//    @JsonProperty("companyId")
//    private Long companyId;

//    public Long getCompanyId() {
//        return companyId;
//    }
//
//    public void setCompanyId(Long companyId) {
//        this.companyId = companyId;
//    }

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
}
