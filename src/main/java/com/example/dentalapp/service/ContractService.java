package com.example.dentalapp.service;

import com.example.dentalapp.model.Contract;
import com.example.dentalapp.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContractService {
    private ContractRepository contractRepository;

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
    public Contract editContract(Contract contract) {
        Contract contractEdited =  contractRepository.findById(contract.getId());
        contractEdited.setType(contract.getType());

        return contractEdited;
    }

    public void deleteContract(long id) {
        contractRepository.deleteById(id);
    }
}
