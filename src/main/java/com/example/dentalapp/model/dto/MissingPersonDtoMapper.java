package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.MissingPerson;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class MissingPersonDtoMapper {

    public static List<MissingPersonDto> mapMissingToDtos(List<MissingPerson> missingPeople){
        return missingPeople.stream()
                .map(MissingPersonDtoMapper::mapToMissingPersonDto)
                .collect(Collectors.toList());
    }

    public static MissingPersonDto mapToMissingPersonDto(MissingPerson missingPerson) {

        if(missingPerson.getEmployee() == null) {
            return MissingPersonDto.builder()
                    .id(missingPerson.getId())
                    .beggingDate(missingPerson.getBeggingDate())
                    .comebackDate(missingPerson.getComebackDate())
                    .leaveName(missingPerson.getLeave().getType())
                    .build();
        }
        else if(missingPerson.getLeave() == null) {
            return MissingPersonDto.builder()
                    .id(missingPerson.getId())
                    .beggingDate(missingPerson.getBeggingDate())
                    .comebackDate(missingPerson.getComebackDate())
                    .employeeId(missingPerson.getEmployee().getId())
                    .employeeName(missingPerson.getEmployee().getName())
                    .employeeSurname(missingPerson.getEmployee().getSurname())
                    .employeePhoneNumber(missingPerson.getEmployee().getPhoneNumber())
                    .employeePosition(missingPerson.getEmployee().getPosition().getName())
                    .employeeEmail(missingPerson.getEmployee().getEmail())
                    .build();
        }
        else {
            return MissingPersonDto.builder()
                    .id(missingPerson.getId())
                    .beggingDate(missingPerson.getBeggingDate())
                    .comebackDate(missingPerson.getComebackDate())
                    .leaveName(missingPerson.getLeave().getType())
                    .employeeId(missingPerson.getEmployee().getId())
                    .employeeName(missingPerson.getEmployee().getName())
                    .employeeSurname(missingPerson.getEmployee().getSurname())
                    .employeePhoneNumber(missingPerson.getEmployee().getPhoneNumber())
                    .employeePosition(missingPerson.getEmployee().getPosition().getName())
                    .employeeEmail(missingPerson.getEmployee().getEmail())
                    .build();
        }
    }
}
