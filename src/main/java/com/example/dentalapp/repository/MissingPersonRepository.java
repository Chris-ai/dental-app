package com.example.dentalapp.repository;

import com.example.dentalapp.model.MissingPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MissingPersonRepository extends JpaRepository<MissingPerson,Long> {

    List<MissingPerson> findAll();
    MissingPerson findById(long id);
}
