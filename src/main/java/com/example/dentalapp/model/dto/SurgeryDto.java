package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class SurgeryDto {
    private long id;
    private String name;
    private String description;
    private List<MedicineDto> medicineList;
}

