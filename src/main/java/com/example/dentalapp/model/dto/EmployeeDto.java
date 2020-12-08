package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class EmployeeDto {
    private long id;
    private String position;
    private String contract;
    private String name;
    private String surname;
    private String pesel;
    private Date dateOfEmployment;
    private String email;
    private long phoneNumber;
    private float salary;
}
