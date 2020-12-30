package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Leave;
import com.example.dentalapp.model.Medicine;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class LeaveDtoMapper {

    public static List<LeaveDto> mapLeavesToDtos(List<Leave> leaves){
        return leaves.stream()
                .map(LeaveDtoMapper::mapLeaveToDto)
                .collect(Collectors.toList());
    }

    public static LeaveDto mapLeaveToDto(Leave leave) {
        return LeaveDto.builder()
                .id(leave.getId())
                .type(leave.getType())
                .isPayed(leave.getIsPayed())
                .missingPeople(MissingPersonDtoMapper.mapMissingToDtos(leave.getMissingPeople()))
                .build();
    }
}
