package com.example.dentalapp.repository;

import com.example.dentalapp.model.Visit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit,Long> {
    List<Visit> findAll();
    Visit findById(long id);
}