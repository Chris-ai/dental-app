package com.example.dentalapp.controller;

import com.example.dentalapp.model.Role;
import com.example.dentalapp.service.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("roles")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
