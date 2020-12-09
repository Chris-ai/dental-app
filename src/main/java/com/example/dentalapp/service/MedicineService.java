package com.example.dentalapp.service;

import com.example.dentalapp.model.Medicine;
import com.example.dentalapp.repository.MedicineRepository;
import com.example.dentalapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository, OrderRepository orderRepository) {
        this.medicineRepository = medicineRepository;
        this.orderRepository = orderRepository;
    }

    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine createNewMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Transactional
    public Medicine editMedicine(Medicine medicine, long id) {
        Medicine medicineEdited = medicineRepository.findById(id);

        medicineEdited.setName(medicine.getName());
        medicineEdited.setAmount(medicine.getAmount());
        medicineEdited.setDescription(medicine.getDescription());

        return medicineEdited;
    }

    public void deleteMedicine(long id) {
        Medicine medicineDeleted = medicineRepository.findById(id);
        orderRepository.deleteAll(medicineDeleted.getOrderList());
        medicineRepository.delete(medicineDeleted);
    }

    public Medicine getSingleMedicines(long id) {
        return medicineRepository.findById(id);
    }
}
