package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class PatientDto {
    private long id;
    private long cardId;
    private String name;
    private String surname;
    private String pesel;
    private Date registerDate;
    private Date bornDate;
    private String city;
    private String address;
    private String email;
    private String zipCode;
    private long phoneNumber;
    private String extra_info;
    private List<VisitDto> visits;
}

