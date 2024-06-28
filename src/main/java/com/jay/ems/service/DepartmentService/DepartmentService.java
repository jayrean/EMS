package com.jay.ems.service.DepartmentService;

import com.jay.ems.Entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(Long id);
    Department saveDepartment(Department department);
    void deleteDepartment(Long id);
}
