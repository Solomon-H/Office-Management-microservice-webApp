package com.managementsystem.microserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.managementsystem.microserviceproject.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentById(Long id);
}
