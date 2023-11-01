package com.managementsystem.microserviceproject.Response;

import lombok.Data;

@Data
public class DepartmentResponse {
    private Long id;
    private String departmentName;
    private String departmentAddress;

}