package com.jay.ems.service.StudentService;


import com.jay.ems.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
}
