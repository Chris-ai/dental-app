package com.example.dentalapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestController {

    @GetMapping("/all")
    public String allAccess(){
        return "Public content";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String userAccess(){
        return "hello user or admin";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess(){
        return "Hello admin";
    }
}
