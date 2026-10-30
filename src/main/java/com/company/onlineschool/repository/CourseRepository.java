package com.company.onlineschool.repository;
import com.company.onlineschool.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course, Long> { }
