package com.example.dentalapp.repository;

import com.example.dentalapp.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave,Long> {
    List<Leave> findAll();
    Leave findById(long id);
}