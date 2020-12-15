package com.example.dentalapp.service;

import com.example.dentalapp.model.Contract;
import com.example.dentalapp.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }

    public List<Contract> getContractsByName(String name) {
        return contractRepository.findByName(name);
    }

    public Contract getSingleContract(long id) {
        return contractRepository.findById(id);
    }

    public Contract createContact(Contract contract) {
        return contractRepository.save(contract);
    }

    @Transactional
    public Contract editContract(Contract contract, long contractId) {
        Contract contractEdited = contractRepository.findById(contractId);
        contractEdited.setType(contract.getType());
        return contractEdited;
    }

    public void deleteContract(long id) {
        contractRepository.deleteById(id);
    }
}
