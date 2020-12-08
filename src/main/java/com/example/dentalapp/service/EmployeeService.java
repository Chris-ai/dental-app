package com.example.dentalapp.service;

import com.example.dentalapp.model.Account;
import com.example.dentalapp.model.Employee;
import com.example.dentalapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private static final String SIMPLE_PASSWORD = "BDFHAS#14";
    private static final String ROLE = "USER";
    private final EmployeeRepository employeeRepository;
    private final AccountService accountService;
    private final MissingPersonService missingPersonService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AccountService accountService, MissingPersonService missingPersonService) {
        this.employeeRepository = employeeRepository;
        this.accountService = accountService;
        this.missingPersonService = missingPersonService;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public Employee addNewEmployee(Employee employee) {
        accountService.createAccount(CreateAccountForEmployee(employee));
        return employeeRepository.save(employee);
    }


    private Account CreateAccountForEmployee(Employee employee){
        String username = employee.getPesel();
        return new Account(username, SIMPLE_PASSWORD);
    }

    @Transactional
    public Employee editEmployee(Employee employee) {
        Employee employeeEdited = employeeRepository.findById(employee.getId());
        employeeEdited.setName(employee.getName());
        employeeEdited.setSurname(employee.getSurname());
        employeeEdited.setPesel(employee.getPesel());
        employeeEdited.setDateOfEmployment(employee.getDateOfEmployment());
        employeeEdited.setPhoneNumber(employee.getPhoneNumber());
        employeeEdited.setEmail(employee.getEmail());
        employeeEdited.setSalary(employee.getSalary());
        employeeEdited.setContract(employee.getContract());
        employeeEdited.setPosition(employee.getPosition());

        return employeeEdited;
    }

    public void deleteEmployee(long id) {
        accountService.deleteAccount(employeeRepository.findById(id).getAccount().getId());
        missingPersonService.deleteMissingPerson(employeeRepository.findById(id).getId());
        employeeRepository.deleteById(id);
    }
}
