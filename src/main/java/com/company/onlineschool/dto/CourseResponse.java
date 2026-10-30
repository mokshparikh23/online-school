package com.company.onlineschool.dto;
public class CourseResponse {
    private Long courseId; private String courseName; private String courseDescription; private int credits; private String message;
    public Long getCourseId(){return courseId;} public void setCourseId(Long v){courseId=v;}
    public String getCourseName(){return courseName;} public void setCourseName(String v){courseName=v;}
    public String getCourseDescription(){return courseDescription;} public void setCourseDescription(String v){courseDescription=v;}
    public int getCredits(){return credits;} public void setCredits(int v){credits=v;}
    public String getMessage(){return message;} public void setMessage(String v){message=v;}
}
