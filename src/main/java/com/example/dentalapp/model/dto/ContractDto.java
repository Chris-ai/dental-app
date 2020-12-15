package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ContractDto {
    long id;
    String name;
    List<EmployeeDto> employees;
}
