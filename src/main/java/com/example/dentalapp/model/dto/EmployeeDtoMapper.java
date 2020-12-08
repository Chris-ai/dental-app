package com.example.dentalapp.model.dto;


import com.example.dentalapp.model.Employee;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@NoArgsConstructor
public class EmployeeDtoMapper {

    public static List<EmployeeDto> mapToEmployeeDtos(List<Employee> employees){
        return employees.stream()
                .map(EmployeeDtoMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .pesel(employee.getPesel())
                .dateOfEmployment(employee.getDateOfEmployment())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .salary(employee.getSalary())
                .contract(employee.getContract().getType())
                .position(employee.getPosition().getName())
                .build();
    }

}
