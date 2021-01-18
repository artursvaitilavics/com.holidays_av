package com.holidays_av.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto {

    @JsonProperty("id")
    private Long id;

    @NotEmpty(message = "Please check name")
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "Please check lastname")
    @JsonProperty("last_name")
    private String lastName;

    @Email(message = "Please check email")
    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
