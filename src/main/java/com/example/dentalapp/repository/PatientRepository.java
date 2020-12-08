package com.example.dentalapp.repository;

import com.example.dentalapp.model.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAll();
    Patient findById(long id);
    @Query("select p from Pacjent p left join fetch p.visitList")
    List<Patient> findAllPatients();
}

