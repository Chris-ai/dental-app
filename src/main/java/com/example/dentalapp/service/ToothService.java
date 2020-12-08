package com.example.dentalapp.service;

import com.example.dentalapp.model.Tooth;
import com.example.dentalapp.repository.ToothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToothService {

    ToothRepository toothRepository;

    @Autowired
    public ToothService(ToothRepository toothRepository) {
        this.toothRepository = toothRepository;
    }

    public List<Tooth> getTeeth() {
        return toothRepository.findAll();
    }

    public Tooth getTooth(long id) {
        return toothRepository.findById(id);
    }

    public Tooth createTooth(Tooth tooth) {
        return toothRepository.save(tooth);
    }

    @Transactional
    public Tooth editTooth(Tooth tooth) {
        Tooth toothEdited = toothRepository.findById(tooth.getId());
        toothEdited.setName(tooth.getName());
        return toothEdited;
    }

    public void deleteTooth(long id) {
        toothRepository.deleteById(id);
    }
}
