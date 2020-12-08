package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Patient;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PatientDtoMapper {

    public static List<PatientDto> mapToPatientDtos(List<Patient> patients) {
        return patients.stream()
                .map(PatientDtoMapper::mapToPatientDto)
                .collect(Collectors.toList());
    }

    public static PatientDto mapToPatientDto(Patient patient){
        return PatientDto.builder()
                .id(patient.getId())
                .cardId(patient.getCardId())
                .name(patient.getName())
                .surname(patient.getSurname())
                .bornDate(patient.getBornDate())
                .address(patient.getAddress())
                .city(patient.getCity())
                .email(patient.getEmail())
                .registerDate(patient.getRegisterDate())
                .phoneNumber(patient.getPhoneNumber())
                .pesel(patient.getPesel())
                .zipCode(patient.getZipCode())
                .extra_info(patient.getExtra_info())
                .visits(VisitDtoMapper.mapToVisitDtos(patient.getVisitList()))
                .build();
    }

}
