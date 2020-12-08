package com.example.dentalapp.service;

import com.example.dentalapp.model.Patient;
import com.example.dentalapp.model.dto.VisitDto;
import com.example.dentalapp.model.dto.VisitDtoMapper;
import com.example.dentalapp.repository.PatientRepository;
import com.example.dentalapp.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private VisitRepository visitRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public List<VisitDto> getPatientVisits(long id) {
        Patient patient_ = patientRepository.findById(id);
        return VisitDtoMapper.mapToVisitDtos(patient_.getVisitList());
    }

    public Patient getSinglePatient(long id) {
        return patientRepository.findById(id);
    }

    public Patient createNewPatient(Patient patient) {
        patient.setCardId(patient.getId()+100);
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient editPatient(Patient patient) {
        Patient patientEdited = patientRepository.findById(patient.getId());
        patientEdited.setName(patient.getName());
        patientEdited.setSurname(patient.getSurname());
        patientEdited.setAddress(patient.getAddress());
        patientEdited.setBornDate(patient.getBornDate());
        patientEdited.setPesel(patient.getPesel());
        patientEdited.setEmail(patient.getEmail());
        patientEdited.setExtra_info(patient.getExtra_info());
        patientEdited.setZipCode(patient.getZipCode());
        patientEdited.setCity(patient.getCity());
        patientEdited.setPhoneNumber(patient.getPhoneNumber());

        return patientEdited;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAllPatients();
    }

    public void deletePatient(long id) {
        visitRepository.deleteAll(patientRepository.findById(id).getVisitList());
        patientRepository.deleteById(id);
    }
}
