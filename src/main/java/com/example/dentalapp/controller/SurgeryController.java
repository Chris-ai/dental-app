package com.example.dentalapp.controller;

import com.example.dentalapp.model.Surgery;
import com.example.dentalapp.model.dto.SurgeryDto;
import com.example.dentalapp.model.dto.SurgeryDtoMapper;
import com.example.dentalapp.service.SurgeryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SurgeryController {
    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping("/surgeries")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<SurgeryDto> getSurgeries(){
        return SurgeryDtoMapper.mapToSurgeryDtos(surgeryService.getSurgeries());
    }

    @GetMapping("/surgeries/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public SurgeryDto getSingleSurgery(@PathVariable long id){
        return SurgeryDtoMapper.mapToSurgeryDto(surgeryService.getSingleSurgery(id));
    }

    @PostMapping("/surgeries")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Surgery createSurgery(@RequestBody Surgery surgery){
        return surgeryService.createNewSurgery(surgery);
    }

    @PutMapping("/surgeries")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Surgery editSurgery(@RequestBody Surgery surgery){
        return surgeryService.editSurgery(surgery);
    }

    @DeleteMapping("/surgeries/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteSurgery(@PathVariable long id){
        surgeryService.deleteSurgery(id);
    }
}
