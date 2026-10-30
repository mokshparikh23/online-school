package com.company.onlineschool.service;

import com.company.onlineschool.dto.*;
import com.company.onlineschool.entity.*;
import com.company.onlineschool.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolServiceImpl implements SchoolService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public SchoolServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override @Transactional
    public CourseResponse createCourse(CourseRequest request) {
        // TODO: map request, save course, and return response with success message.
        return null;
    }

    @Override @Transactional
    public Student createStudent(Long courseId, StudentRequest request) {
        // TODO: validate course, reject duplicate email, map and save student.
        return null;
    }

    @Override @Transactional(readOnly = true)
    public Student getStudent(Long studentId) {
        // TODO: return student or throw ResourceNotFoundException.
        return null;
    }
}
