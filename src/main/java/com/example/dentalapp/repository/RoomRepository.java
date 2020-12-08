package com.example.dentalapp.repository;

import com.example.dentalapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findAll();
    Room findById(long id);
}
