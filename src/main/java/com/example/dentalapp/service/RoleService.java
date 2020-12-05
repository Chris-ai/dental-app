package com.example.dentalapp.service;

import com.example.dentalapp.model.Role;
import com.example.dentalapp.repository.RoleRepostiory;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepostiory roleRepostiory;

    public RoleService(RoleRepostiory roleRepostiory) {
        this.roleRepostiory = roleRepostiory;
    }

    public Role createRole(Role role) {
        return roleRepostiory.save(role);
    }
}
