package com.company.onlineschool.controller;
import com.company.onlineschool.dto.StudentRequest;
import com.company.onlineschool.entity.Student;
import com.company.onlineschool.service.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// TODO: Add REST controller and /students request mapping annotations.
public class StudentController {
    private final SchoolService service;
    public StudentController(SchoolService service){this.service=service;}

    // TODO: Map POST /students/{courseId} and return HTTP 201.
    public ResponseEntity<Student> createStudent(Long courseId, @Valid @RequestBody StudentRequest request) { return null; }

    // TODO: Map GET /students/{studentId} and return HTTP 200.
    public ResponseEntity<Student> getStudent(Long studentId) { return null; }
}
