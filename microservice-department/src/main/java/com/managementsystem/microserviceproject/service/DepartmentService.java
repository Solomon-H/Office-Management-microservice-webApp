package com.managementsystem.microserviceproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.managementsystem.microserviceproject.Response.DepartmentResponse;
import com.managementsystem.microserviceproject.entity.Department;
import com.managementsystem.microserviceproject.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentResponse findDepartmentById(Long id) {
        Department department = departmentRepository.findDepartmentById(id);
        DepartmentResponse departmentResponse = modelMapper.map(department, DepartmentResponse.class);
        return departmentResponse;
    }


    public String addDepartment(Department department) {
          departmentRepository.save(department);
          return "New department created";
    }

}