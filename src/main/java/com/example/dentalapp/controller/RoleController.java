package com.example.dentalapp.controller;

import com.example.dentalapp.model.Role;
import com.example.dentalapp.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping("/roles")
    @PreAuthorize("hasRole('ADMIN')")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
