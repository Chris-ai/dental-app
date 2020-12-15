package com.example.dentalapp.controller;

import com.example.dentalapp.model.Contract;
import com.example.dentalapp.model.dto.ContractDto;
import com.example.dentalapp.model.dto.ContractDtoMapper;
import com.example.dentalapp.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<ContractDto> getContracts(){
        return ContractDtoMapper.mapToContractDtos(contractService.getContracts());
    }

    @GetMapping("/contracts/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ContractDto getSingleContract(@PathVariable long id){
        return ContractDtoMapper.mapToContractDto(contractService.getSingleContract(id));
    }

    @PostMapping("/contracts")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Contract createContract(@RequestBody Contract contract){
        return contractService.createContact(contract);
    }

    @PutMapping("/contracts/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Contract editContract(@PathVariable long id,@RequestBody Contract contract){
        return contractService.editContract(contract,id);
    }

    @DeleteMapping("/contracts/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void deleteContract(@PathVariable long id){
        contractService.deleteContract(id);
    }
}
