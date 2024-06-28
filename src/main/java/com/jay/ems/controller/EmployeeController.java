package com.jay.ems.controller;

import com.jay.ems.Entity.Employee;
import com.jay.ems.service.EmployeeService.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveEmployee")

    // we use BindingResult to capture the results happen during request and
    // the errors in the process
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Return a bad request status with validation errors
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }

        employeeService.saveEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showFormForUpdate")
    public ResponseEntity<Employee> showFormForUpdate(@RequestParam("employeeId") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam("employeeId") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
