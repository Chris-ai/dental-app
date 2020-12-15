package com.example.dentalapp.service;

import com.example.dentalapp.model.Visit;
import com.example.dentalapp.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private MedicineService medicineService;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit getSingleVisit(long id){
        return visitRepository.findById(id);
    }

    public List<Visit> getVisits(){
        return visitRepository.findAll();
    }

    public void deleteVisit(long id) {
        visitRepository.deleteById(id);
    }

    public Visit createVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Transactional
    public Visit editVisit(Visit visit, long visitId) {
        Visit visitEdited = visitRepository.findById(visitId);

            visitEdited.setComment(visit.getComment());
            visitEdited.setPatient(visit.getPatient());
            visitEdited.setDateOfVisit(visit.getDateOfVisit());
            visitEdited.setEmployee(visit.getEmployee());
            visitEdited.setRoom(visit.getRoom());
            visitEdited.setSurgery(visit.getSurgery());
            visitEdited.setTeeth(visit.getTeeth());

        return visitEdited;
    }
}
