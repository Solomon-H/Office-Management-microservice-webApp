package com.managementsystem.microserviceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.managementsystem.microserviceproject.Response.DepartmentResponse;
import com.managementsystem.microserviceproject.entity.Department;
import com.managementsystem.microserviceproject.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Long id) {
        DepartmentResponse departmentResponse = departmentService.findDepartmentById(id);;
        return departmentResponse;
    }

    @PostMapping("/new")
    public void newDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }
}
   
