package com.example.dentalapp.controller;

import com.example.dentalapp.model.Room;
import com.example.dentalapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Room> getRooms(){
        return  roomService.getRooms();
    }

    @GetMapping("/rooms/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Room getSingleRoom(@PathVariable long id){
        return roomService.getSingleRoom(id);
    }

    @PostMapping("/rooms")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @PutMapping("/rooms/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Room editRoom(@PathVariable long id ,@RequestBody Room room){
        return roomService.editRoom(room,id);
    }

    @DeleteMapping("/rooms/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteRoom(@PathVariable long id){
        roomService.deleteRoom(id);
    }
}
