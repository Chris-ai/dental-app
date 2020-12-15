package com.example.dentalapp.service;

import com.example.dentalapp.exception.ItemNotFoundException;
import com.example.dentalapp.model.Account;
import com.example.dentalapp.model.Role;
import com.example.dentalapp.repository.AccountRepository;
import com.example.dentalapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, AccountRepository accountRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(long id) {
        return roleRepository.findById(id);
    }
}
