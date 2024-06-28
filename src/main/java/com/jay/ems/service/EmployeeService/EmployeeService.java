package com.jay.ems.service.EmployeeService;

import com.jay.ems.Entity.Employee;

import java.util.List;

// this is the interface where we define all the employee methods

public interface EmployeeService {


    // here we defined the saveEmployee in the interface
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void saveEmployee(Employee employee);

    void updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);


}
