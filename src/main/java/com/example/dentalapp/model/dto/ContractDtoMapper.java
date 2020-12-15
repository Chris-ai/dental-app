package com.example.dentalapp.model.dto;

import com.example.dentalapp.model.Contract;
import com.example.dentalapp.model.Position;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class ContractDtoMapper {

    public static List<ContractDto> mapToContractDtos(List<Contract> contracts){
        return contracts.stream()
                .map(ContractDtoMapper::mapToContractDto)
                .collect(Collectors.toList());
    }

    public static ContractDto mapToContractDto(Contract contract) {
        return ContractDto.builder()
                .id(contract.getId())
                .name(contract.getType())
                .employees(EmployeeDtoMapper.mapToEmployeeDtos(contract.getEmployeeList()))
                .build();
    }
}
