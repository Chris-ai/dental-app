package com.example.dentalapp.controller;

import com.example.dentalapp.model.Employee;
import com.example.dentalapp.model.dto.EmployeeDto;
import com.example.dentalapp.model.dto.EmployeeDtoMapper;
import com.example.dentalapp.service.EmployeeService;
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

    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee editEmployee(@RequestBody Employee employee){
        return employeeService.editEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
