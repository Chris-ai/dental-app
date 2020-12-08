package com.example.dentalapp.repository;

import com.example.dentalapp.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    List<Medicine> findAll();
    Medicine findById(long id);
}

