package com.example.dentalapp.repository;

import com.example.dentalapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAll();
    @Query("select k from konto k where k.id = :id")
    Account findAccountById(long id);
    Optional<Account> findByUsername(String username);
}
