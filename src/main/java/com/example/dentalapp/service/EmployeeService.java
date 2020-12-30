package com.example.dentalapp.service;

import com.example.dentalapp.model.Account;
import com.example.dentalapp.model.Employee;
import com.example.dentalapp.model.Role;
import com.example.dentalapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    private static final String SIMPLE_PASSWORD = "BDFHAS#14";
    private static final int USER_ROLE_ID = 2;
    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;
    private final AccountService accountService;
    private final MissingPersonService missingPersonService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleService roleService, AccountService accountService, MissingPersonService missingPersonService) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
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
        Account userAccount = new Account(username, SIMPLE_PASSWORD);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getRoleById(USER_ROLE_ID));
        userAccount.setRoles(userRoles);
        //roleService.addRoleToAccount(userAccount,roleService.getRoleById(ROLE_ID));

        employee.setAccount(userAccount);
        return userAccount;
    }

    @Transactional
    public Employee editEmployee(Employee employee, long id) {
        Employee employeeEdited = employeeRepository.findById(id);
        employeeEdited.setName(employee.getName());
        employeeEdited.setSurname(employee.getSurname());
        employeeEdited.setPesel(employee.getPesel());
        employeeEdited.setAge(employee.getAge());
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

    public List<Employee> getDentists() {
        return employeeRepository.findAllDentists("Stomatolog");
    }
}
