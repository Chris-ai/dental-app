package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Position;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PositionDtoMapper {

    public static List<PositionDto> mapToPositionDtos(List<Position> positionList){
        return positionList.stream()
                .map(PositionDtoMapper::mapToPositionDto)
                .collect(Collectors.toList());
    }

    public static PositionDto mapToPositionDto(Position position) {
        return PositionDto.builder()
                .id(position.getId())
                .name(position.getName())
                .employees(EmployeeDtoMapper.mapToEmployeeDtos(position.getEmployees()))
                .build();
    }
}
