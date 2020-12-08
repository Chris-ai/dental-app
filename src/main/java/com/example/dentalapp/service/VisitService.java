package com.example.dentalapp.service;

import com.example.dentalapp.model.Visit;
import com.example.dentalapp.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitService {

    private VisitRepository visitRepository;

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
    public Visit editVisit(Visit visit) {
        Visit visitEdited = visitRepository.findById(visit.getId());

        if(visit.getComment() != null){
            visitEdited.setComment(visit.getComment());
        }
        if(visit.getPatient() != null){
            visitEdited.setPatient(visit.getPatient());
        }
        if(visit.getDateOfVisit() != null){
            visitEdited.setDateOfVisit(visit.getDateOfVisit());
        }
        if(visit.getEmployee() != null){
            visitEdited.setEmployee(visit.getEmployee());
        }
        if(visit.getRoom() != null){
            visitEdited.setRoom(visit.getRoom());
        }
        if(visit.getSurgery() != null){
            visitEdited.setSurgery(visit.getSurgery());
        }
        if(visit.getTeeth() != null){
            visitEdited.setTeeth(visit.getTeeth());
        }

        return visitEdited;
    }
}
