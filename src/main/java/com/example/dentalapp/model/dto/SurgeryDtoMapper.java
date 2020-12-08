package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Surgery;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class SurgeryDtoMapper {

    public static List<SurgeryDto> mapToSurgeryDtos(List<Surgery> surgeryList){
        return surgeryList.stream()
                .map(SurgeryDtoMapper::mapToSurgeryDto)
                .collect(Collectors.toList());
    }

    public static SurgeryDto mapToSurgeryDto(Surgery surgery) {
        return SurgeryDto.builder()
                .id(surgery.getId())
                .name(surgery.getName())
                .description(surgery.getDescription())
                .medicineList(MedicineDtoMapper.mapMedicineToDtos(surgery.getMedicineList()))
                .build();
    }
}
