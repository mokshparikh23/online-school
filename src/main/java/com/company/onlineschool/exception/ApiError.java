package com.company.onlineschool.exception;
public class ApiError {
    private int status; private String message;
    public ApiError(int status,String message){this.status=status;this.message=message;}
    public int getStatus(){return status;} public String getMessage(){return message;}
}
