package com.managementsystem.microserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.managementsystem.microserviceproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Employee findEmployeeById(Long id);   
    
}