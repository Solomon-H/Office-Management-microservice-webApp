package com.managementsystem.microserviceproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
        // Get employee data entity from database
        Employee employee = employeeRepository.findEmployeeById(id);

        // RestTemplate to fetch department data
        DepartmentResponse departmentResponse = restTemplate.getForObject(
                                                "http://localhost:8081/departments/{id}",DepartmentResponse.class,id );
         // 1st way to convert entity to response 
        // EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        // 2nd way to convert entity to response 
        BeanUtils.copyProperties(employee, employeeResponse);

        employeeResponse.setDepartment(departmentResponse);
        return employeeResponse;

    }


    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}