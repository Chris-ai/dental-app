package com.example.dentalapp.repository;

import com.example.dentalapp.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery,Long> {
    @Query("select z from Zabieg z left join fetch z.medicineList")
    List<Surgery> findAll();
    Surgery findById(long id);
}
