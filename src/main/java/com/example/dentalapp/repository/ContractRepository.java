package com.example.dentalapp.repository;

import com.example.dentalapp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {

    List<Contract> findAll();
    @Query("select u from Umowa u where u.type = :name")
    List<Contract> findByName(String name);
    Contract findById(long id);
}

