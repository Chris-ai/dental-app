package com.example.dentalapp.service;

import com.example.dentalapp.model.Room;
import com.example.dentalapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }

    @Transactional
    public Room editRoom(Room room) {
        Room roomEdited = roomRepository.findById(room.getId());
        roomEdited.setNumber(room.getNumber());
        return roomEdited;
    }

    public Room getSingleRoom(long id) {
        return roomRepository.findById(id);
    }
}
