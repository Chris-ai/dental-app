package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LeaveDto {

    long id;
    String type;
    Boolean isPayed;
    List<MissingPersonDto> missingPeople;
}
