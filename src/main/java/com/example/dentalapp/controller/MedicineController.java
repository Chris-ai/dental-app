package com.example.dentalapp.controller;

import com.example.dentalapp.model.Medicine;
import com.example.dentalapp.model.dto.MedicineDto;
import com.example.dentalapp.model.dto.MedicineDtoMapper;
import com.example.dentalapp.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MedicineController {
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<MedicineDto> getMedicines(){
        return MedicineDtoMapper.mapMedicineToDtos(medicineService.getMedicines());
    }

    @GetMapping("/medicines/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MedicineDto getMedicines(@PathVariable long id){
        return MedicineDtoMapper.mapMedicineToDto(medicineService.getSingleMedicines(id));
    }

    @PostMapping("/medicines")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineService.createNewMedicine(medicine);
    }

    @PutMapping("/medicines/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Medicine editMedicine(@PathVariable long id, @RequestBody Medicine medicine){
        return medicineService.editMedicine(medicine,id);
    }

    @DeleteMapping("/medicines/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteMedicine(@PathVariable long id){
        medicineService.deleteMedicine(id);
    }
}
