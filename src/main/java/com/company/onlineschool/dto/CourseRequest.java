package com.company.onlineschool.dto;
import jakarta.validation.constraints.*;
public class CourseRequest {
    @NotBlank private String courseName;
    @NotBlank private String courseDescription;
    @Min(1) @Max(10) private int credits;
    public String getCourseName(){return courseName;} public void setCourseName(String v){courseName=v;}
    public String getCourseDescription(){return courseDescription;} public void setCourseDescription(String v){courseDescription=v;}
    public int getCredits(){return credits;} public void setCredits(int v){credits=v;}
}
