package com.example.dentalapp.controller;

import com.example.dentalapp.model.Tooth;
import com.example.dentalapp.service.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ToothController {

    private final ToothService toothService;

    @Autowired
    public ToothController(ToothService toothService) {
        this.toothService = toothService;
    }

    @GetMapping("/teeth")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Tooth> getTeeth(){
        return toothService.getTeeth();
    }

    @GetMapping("/teeth/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Tooth getTooth(@PathVariable long id){
        return toothService.getTooth(id);
    }

    @PostMapping("/teeth")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Tooth createTooth(@RequestBody Tooth tooth){
        return toothService.createTooth(tooth);
    }

    @PutMapping("/teeth/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Tooth editTooth(@RequestBody Tooth tooth,@PathVariable long id){
        return toothService.editTooth(tooth,id);
    }

    @DeleteMapping("/teeth/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteTooth(@PathVariable long id){
        toothService.deleteTooth(id);
    }
}
