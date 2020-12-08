package com.example.dentalapp.service;

import com.example.dentalapp.model.Surgery;
import com.example.dentalapp.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SurgeryService {

    SurgeryRepository surgeryRepository;

    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public List<Surgery> getSurgeries() {
        return surgeryRepository.findAll();
    }

    public Surgery getSingleSurgery(long id) {
        return surgeryRepository.findById(id);
    }

    public Surgery createNewSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Transactional
    public Surgery editSurgery(Surgery surgery) {
        Surgery surgeryEdited = surgeryRepository.findById(surgery.getId());
        surgeryEdited.setName(surgery.getName());
        surgeryEdited.setDescription(surgery.getDescription());
        surgeryEdited.setMedicineList(surgery.getMedicineList());

        return surgeryEdited;
    }

    public void deleteSurgery(long id) {
        surgeryRepository.deleteById(id);
    }
}
