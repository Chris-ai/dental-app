package com.example.dentalapp.model.dto;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MedicineDto {
    private long id;
    private String name;
    private double amount;
    private String description;
}

