package com.example.dentalapp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RoomDto {

    private long id;
    private int number;
}
