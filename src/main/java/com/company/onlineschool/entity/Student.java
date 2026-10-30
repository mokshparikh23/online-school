package com.company.onlineschool.entity;

import jakarta.persistence.*;

// TODO: Add the annotation that marks this class as a JPA entity.
public class Student {
    // TODO: Mark as primary key and configure generated values.
    private Long studentId;
    private String firstName;
    private String lastName;
    // TODO: Make email unique and non-null at database level.
    private String email;

    // TODO: Map the owning many-to-one association as mandatory.
    // TODO: Use a non-null course_id join column.
    private Course course;

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
