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

        if(visit.getPatient() == null){
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .employeeName(visit.getEmployee().getName())
                    .employeeSurname(visit.getEmployee().getSurname())
                    .surgery(visit.getSurgery().getName())
                    .room(visit.getRoom().getNumber())
                    .build();
        } else if(visit.getEmployee() == null){
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .patientName(visit.getPatient().getName())
                    .patientSurname(visit.getPatient().getSurname())
                    .surgery(visit.getSurgery().getName())
                    .room(visit.getRoom().getNumber())
                    .build();
        } else if(visit.getSurgery() == null){
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .employeeName(visit.getEmployee().getName())
                    .employeeSurname(visit.getEmployee().getSurname())
                    .patientName(visit.getPatient().getName())
                    .patientSurname(visit.getPatient().getSurname())
                    .room(visit.getRoom().getNumber())
                    .build();
        } else if(visit.getRoom() == null){
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .employeeName(visit.getEmployee().getName())
                    .employeeSurname(visit.getEmployee().getSurname())
                    .patientName(visit.getPatient().getName())
                    .patientSurname(visit.getPatient().getSurname())
                    .surgery(visit.getSurgery().getName())
                    .build();
        } else {
            return VisitDto.builder()
                    .id(visit.getId())
                    .DateOfVisit(visit.getDateOfVisit())
                    .comment(visit.getComment())
                    .employeeName(visit.getEmployee().getName())
                    .employeeSurname(visit.getEmployee().getSurname())
                    .patientName(visit.getPatient().getName())
                    .patientSurname(visit.getPatient().getSurname())
                    .surgery(visit.getSurgery().getName())
                    .room(visit.getRoom().getNumber())
                    .build();
        }
    }
}
