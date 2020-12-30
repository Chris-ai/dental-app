package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Visit;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class VisitDtoMapper {

    public static List<VisitDto> mapToVisitDtos(List<Visit> visits){
        return visits.stream()
                .map(VisitDtoMapper::mapToVisitDto)
                .collect(Collectors.toList());
    }

    public static VisitDto mapToVisitDto(Visit visit) {
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .employeeId(visit.getEmployee().getId())
                    .employeeName(visit.getEmployee().getName())
                    .employeeSurname(visit.getEmployee().getSurname())
                    .patientName(visit.getPatient().getName())
                    .patientSurname(visit.getPatient().getSurname())
                    .surgery(visit.getSurgery().getName())
                    .build();
        }
    }

