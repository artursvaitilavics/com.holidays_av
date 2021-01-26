package com.holidays_av.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicDto {

    @JsonProperty("id")
    private Long id;

//    @NotEmpty(message = "Please check name....")
    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
