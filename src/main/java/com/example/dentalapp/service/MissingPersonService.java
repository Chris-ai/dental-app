package com.example.dentalapp.service;

import com.example.dentalapp.model.MissingPerson;
import com.example.dentalapp.repository.MissingPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MissingPersonService {

    private final MissingPersonRepository missingPersonRepository;

    @Autowired
    public MissingPersonService(MissingPersonRepository missingPersonRepository) {
        this.missingPersonRepository = missingPersonRepository;
    }

    public List<MissingPerson> getMissingPeople() {
        return missingPersonRepository.findAll();
    }

    public MissingPerson getSingleMissing(long id) {
        return missingPersonRepository.findById(id);
    }

    public MissingPerson createSingleMissingPerson(MissingPerson people) {
        return missingPersonRepository.save(people);
    }

    @Transactional
    public MissingPerson editMissingPerson(MissingPerson people,long leaveId) {
        MissingPerson missingPersonEdited = missingPersonRepository.findById(leaveId);
        missingPersonEdited.setBeggingDate(people.getBeggingDate());
        missingPersonEdited.setComebackDate(people.getComebackDate());
        missingPersonEdited.setLeave(people.getLeave());

        return missingPersonEdited;
    }

    public void deleteMissingPerson(long id) {
        missingPersonRepository.deleteById(id);
    }

    public void deleteAllMissingPeople() {
        missingPersonRepository.deleteAll();
    }
}
