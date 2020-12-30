package com.example.dentalapp.controller;

import com.example.dentalapp.model.Employee;
import com.example.dentalapp.model.dto.EmployeeDto;
import com.example.dentalapp.model.dto.EmployeeDtoMapper;
import com.example.dentalapp.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<EmployeeDto> getEmployees() {return EmployeeDtoMapper.mapToEmployeeDtos(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public EmployeeDto getEmployeeById(@PathVariable long id){
        return EmployeeDtoMapper.mapToEmployeeDto(employeeService.getEmployeeById(id));
    }

    @GetMapping("/employees/dentists")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<EmployeeDto> getDentists(){
        return EmployeeDtoMapper.mapToEmployeeDtos(employeeService.getDentists());
    }

    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee editEmployee(@PathVariable long id,@RequestBody Employee employee){
        return employeeService.editEmployee(employee,id);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
