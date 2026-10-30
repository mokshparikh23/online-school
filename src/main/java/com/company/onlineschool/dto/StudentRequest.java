package com.company.onlineschool.dto;
import jakarta.validation.constraints.*;
public class StudentRequest {
    @NotBlank private String firstName; @NotBlank private String lastName; @NotBlank @Email private String email;
    public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
    public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
}
