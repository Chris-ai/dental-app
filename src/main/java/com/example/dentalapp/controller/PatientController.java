package com.example.dentalapp.controller;

import com.example.dentalapp.model.Patient;
import com.example.dentalapp.model.dto.PatientDto;
import com.example.dentalapp.model.dto.PatientDtoMapper;
import com.example.dentalapp.model.dto.VisitDto;
import com.example.dentalapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PatientDto> getPatients() {
        return PatientDtoMapper.mapToPatientDtos(patientService.getPatients());
    }

    @GetMapping("/patients/{id}/visits")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<VisitDto> getPatientVisits(@PathVariable long id) {
        return patientService.getPatientVisits(id);
    }

    @GetMapping("/patients/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientDto getSinglePatient(@PathVariable long id) {
        return PatientDtoMapper.mapToPatientDto(patientService.getSinglePatient(id));
    }

    @PostMapping("/patients")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createNewPatient(patient);
    }

    @PutMapping("/patients/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Patient editPatient(@PathVariable long id,@RequestBody Patient patient) {
        return patientService.editPatient(patient, id);
    }

    @DeleteMapping("/patients/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deletePatient(@PathVariable long id){
        patientService.deletePatient(id);
    }
}
