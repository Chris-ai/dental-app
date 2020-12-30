package com.example.dentalapp.controller;

import com.example.dentalapp.model.MissingPerson;
import com.example.dentalapp.model.dto.MissingPersonDto;
import com.example.dentalapp.model.dto.MissingPersonDtoMapper;
import com.example.dentalapp.service.MissingPersonService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MissingPersonController {
    private final MissingPersonService missingPersonService;

    public MissingPersonController(MissingPersonService missingPersonService) {
        this.missingPersonService = missingPersonService;
    }

    @GetMapping("/missing")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<MissingPersonDto> getMissingPeople(){
        return MissingPersonDtoMapper.mapMissingToDtos(missingPersonService.getMissingPeople());
    }

    @GetMapping("/missing/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MissingPersonDto getSingleMissing(@PathVariable long id){
        return MissingPersonDtoMapper.mapToMissingPersonDto(missingPersonService.getSingleMissing(id));
    }

    @PostMapping("/missing")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MissingPersonDto createSingleMissingPerson(@RequestBody MissingPerson people){
        return MissingPersonDtoMapper.mapToMissingPersonDto(missingPersonService.createSingleMissingPerson(people));
    }

    @PutMapping("/missing/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MissingPersonDto editMissingPerson(@PathVariable long id ,@RequestBody MissingPerson people){
        return MissingPersonDtoMapper.mapToMissingPersonDto(missingPersonService.editMissingPerson(people,id));
    }
    @DeleteMapping("/missing/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMissingPerson(@PathVariable long id){
        missingPersonService.deleteMissingPerson(id);
    }

    @DeleteMapping("/missing")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllMissingPeople(){
        missingPersonService.deleteAllMissingPeople();
    }
}
