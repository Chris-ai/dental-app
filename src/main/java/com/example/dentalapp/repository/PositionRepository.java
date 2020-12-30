package com.example.dentalapp.repository;

import com.example.dentalapp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {
    Position findById(long id);
    List<Position> findAll();
}
