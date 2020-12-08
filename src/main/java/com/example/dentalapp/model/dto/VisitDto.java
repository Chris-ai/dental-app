package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Tooth;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class VisitDto {
    private long id;
    private Date DateOfVisit;
    private String comment;
    private String patientName;
    private String patientSurname;
    private String employeeName;
    private String employeeSurname;
    private String surgery;
    private String toothName;
    private int room;
}

