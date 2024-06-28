package com.jay.ems.controller;

import com.jay.ems.service.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    // we use Question Mark so it can return Sucess or error message or any other return type
    public ResponseEntity<?> saveStudent(@Validated @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }

        studentService.saveStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showFormForUpdate")
    public ResponseEntity<Student> showFormForUpdate(@RequestParam("studentId") Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestParam("studentId") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}