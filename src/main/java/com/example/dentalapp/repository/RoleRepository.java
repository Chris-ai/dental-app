package com.example.dentalapp.repository;

import com.example.dentalapp.model.Account;
import com.example.dentalapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findById(long id);
}
