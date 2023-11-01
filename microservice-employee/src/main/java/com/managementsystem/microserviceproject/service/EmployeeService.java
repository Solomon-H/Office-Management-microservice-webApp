package com.managementsystem.microserviceproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.managementsystem.microserviceproject.entity.Employee;
import com.managementsystem.microserviceproject.repository.EmployeeRepository;
import com.managementsystem.microserviceproject.responseDto.DepartmentResponse;
import com.managementsystem.microserviceproject.responseDto.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    public EmployeeResponse findEmployeeWithDepartmentById(Long id) {
        Employee employee = employeeRepository.findEmployeeById(id);

        // RestTemplate to fetch department data
        DepartmentResponse departmentResponse = 
             restTemplate.getForObject("http://localhost:8081/departments/{id}",DepartmentResponse.class,id );

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        employeeResponse.setDepartment(departmentResponse);

        return employeeResponse;
    }
    

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }



    // public DepartmentResponse getDepartmentDataById(Long id) {
    //     String url = "http://localhost:8081/departments/{id}";
    //     DepartmentResponse departmentResponse = restTemplate.getForObject(url, DepartmentResponse.class, id);
    //     return departmentResponse;
    // }

}