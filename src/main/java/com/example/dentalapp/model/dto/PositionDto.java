package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
public class PositionDto {

    private long id;
    private String name;
    private List<EmployeeDto> employees;
}