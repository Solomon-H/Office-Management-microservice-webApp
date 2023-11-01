package com.managementsystem.microserviceproject.responseDto;

import lombok.Data;

@Data
public class DepartmentResponse {
    private Long id;
    private String departmentName;
    private String departmentAddress;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return String return the departmentAddress
     */
    public String getDepartmentAddress() {
        return departmentAddress;
    }

    /**
     * @param departmentAddress the departmentAddress to set
     */
    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

}
