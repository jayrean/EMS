package com.jay.ems.repository;

// the reposity is the package where the crud operations are done
// the package contains the interface to do crud operations

// the interface extends the Jpa Repository

import com.jay.ems.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// here we don't need to add @Repository because the JPA will add it
//Repository Interfaces: These interfaces define methods for interacting with data entities.
// In Spring Data, these interfaces often extend CrudRepository or JpaRepository, providing basic CRUD (Create, Read, Update, Delete) operations.

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
