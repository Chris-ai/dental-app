package com.example.dentalapp.repository;

import com.example.dentalapp.model.Tooth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToothRepository extends JpaRepository<Tooth,Long> {
    List<Tooth> findAll();
    Tooth findById(long id);
}