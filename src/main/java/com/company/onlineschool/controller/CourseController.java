package com.company.onlineschool.controller;
import com.company.onlineschool.dto.*;
import com.company.onlineschool.service.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// TODO: Add REST controller and /courses request mapping annotations.
public class CourseController {
    private final SchoolService service;
    public CourseController(SchoolService service){this.service=service;}

    // TODO: Map POST /courses and return HTTP 201 with CourseResponse.
    public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseRequest request) {
        return null;
    }
}
