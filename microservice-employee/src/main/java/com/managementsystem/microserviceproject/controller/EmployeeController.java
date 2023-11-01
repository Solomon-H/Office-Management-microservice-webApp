package com.managementsystem.microserviceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.managementsystem.microserviceproject.entity.Employee;
import com.managementsystem.microserviceproject.responseDto.DepartmentResponse;
import com.managementsystem.microserviceproject.responseDto.EmployeeResponse;
import com.managementsystem.microserviceproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        EmployeeResponse employeeResponse = employeeService.findEmployeeWithDepartmentById(id);
        return ResponseEntity.ok(employeeResponse);

    }

    @PostMapping("/save")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

    }

    // @GetMapping("/{id}/department")
    // public ResponseEntity<DepartmentResponse> getEmployeeDepartment(@PathVariable Long id) {
    //     DepartmentResponse departmentResponse = employeeService.getDepartmentDataById(id);
    //     return ResponseEntity.ok(departmentResponse);
    // }

}
