package com.example.dentalapp.controller;

import com.example.dentalapp.model.Visit;
import com.example.dentalapp.model.dto.VisitDto;
import com.example.dentalapp.model.dto.VisitDtoMapper;
import com.example.dentalapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visits/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public VisitDto getSingleVisit(@PathVariable long id){
        return VisitDtoMapper.mapToVisitDto(visitService.getSingleVisit(id));
    }

    @GetMapping("/visits")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<VisitDto> getVisits() {return VisitDtoMapper.mapToVisitDtos(visitService.getVisits());
    }

    @PostMapping("/visits")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Visit crateVisit(@RequestBody Visit visit){
        return visitService.createVisit(visit);
    }

    @PutMapping("/visits")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Visit editVisit(@RequestBody Visit visit){
        return visitService.editVisit(visit);
    }

    @DeleteMapping("/visits/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteVisit(@PathVariable long id){
        visitService.deleteVisit(id);
    }
}
