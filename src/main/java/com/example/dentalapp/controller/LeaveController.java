package com.example.dentalapp.controller;

import com.example.dentalapp.model.Leave;
import com.example.dentalapp.service.LeaveService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LeaveController {
    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping("/leaves")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Leave> getLeaves(){
        return leaveService.getLeaves();
    }

    @GetMapping("/leaves/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Leave getSingleLeave(@PathVariable long id){
        return leaveService.getSingleLeave(id);
    }

    @PostMapping("/leaves")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Leave createLeave(@RequestBody Leave leave){
        return leaveService.createLeave(leave);
    }

    @PutMapping("/leaves/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Leave editLeave(@PathVariable long id, @RequestBody Leave leave){
        return  leaveService.editLeave(leave,id);
    }

    @DeleteMapping("leaves/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteLeave(@PathVariable long id){
        leaveService.deleteLeave(id);
    }
}
