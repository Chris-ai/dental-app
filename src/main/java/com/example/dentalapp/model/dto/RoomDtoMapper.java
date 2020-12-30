package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Room;
import com.example.dentalapp.model.Surgery;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class RoomDtoMapper {

    public static List<RoomDto> mapToRoomDtos(List<Room> rooms){
        return rooms.stream()
                .map(RoomDtoMapper::mapToRoomDto)
                .collect(Collectors.toList());
    }

    public static RoomDto mapToRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .number(room.getNumber())
                .build();
    }
}
