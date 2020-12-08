package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
public class MissingPersonDto {

    private long id;
    private Date beggingDate;
    private Date comebackDate;
    private String leaveName;
    private long employeeId;
    private String employeePosition;
    private String employeeName;
    private String employeeSurname;
    private String employeeEmail;
    private long employeePhoneNumber;
}
