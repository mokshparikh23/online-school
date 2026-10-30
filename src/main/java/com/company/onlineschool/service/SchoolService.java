package com.company.onlineschool.service;
import com.company.onlineschool.dto.*;
import com.company.onlineschool.entity.Student;
public interface SchoolService {
    CourseResponse createCourse(CourseRequest request);
    Student createStudent(Long courseId, StudentRequest request);
    Student getStudent(Long studentId);
}
