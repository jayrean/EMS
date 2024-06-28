package com.jay.ems.service.EmployeeService;

import com.jay.ems.exception.ResourceNotFoundExeption;
import com.jay.ems.Entity.Employee;
import com.jay.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// this is a class which implements the EmployeeService Interface

// this is service layer for save the employee or creating the employee.


@Service
public class EmployeeServiceImpl implements EmployeeService {

    // now we need to do dependency injection
    // we can do dependnecy injection by constructor based and setter based
    // if we have manditory parameters we use constructor based injection
    // if we have optional parameters we use setter based injection.




    //@Autowired
    // we don't need it because here we have only one constructor in this class.
    // here there is only one Bean
    // so @Autowired annotation can be omitted and spring will use that constructor and inject all the necessary dependencies.
    @Autowired
    private EmployeeRepository repository;


    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    // method to find the employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        if (repository.existsById(id)) {
            employee.setId(id);
            repository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
