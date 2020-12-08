package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Medicine;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class MedicineDtoMapper {

    public static List<MedicineDto> mapMedicineToDtos(List<Medicine> medicines){
        return medicines.stream()
                .map(MedicineDtoMapper::mapMedicineToDto)
                .collect(Collectors.toList());
    }

    public static MedicineDto mapMedicineToDto(Medicine medicine) {
        return MedicineDto.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .amount(medicine.getAmount())
                .description(medicine.getDescription())
                .build();
    }
}
