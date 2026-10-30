package com.company.onlineschool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Add the annotation that marks this class as a JPA entity.
public class Course {
    // TODO: Mark as primary key and configure generated values.
    private Long courseId;
    private String courseName;
    private String courseDescription;
    private int credits;

    // TODO: Map the inverse one-to-many side using Student.course.
    // TODO: Prevent recursive student serialization in a Student response.
    private List<Student> students = new ArrayList<>();

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseDescription() { return courseDescription; }
    public void setCourseDescription(String courseDescription) { this.courseDescription = courseDescription; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
