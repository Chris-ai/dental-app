package com.example.dentalapp.service;

import com.example.dentalapp.config.WebSecurityConfig;
import com.example.dentalapp.exception.ItemNotFoundException;
import com.example.dentalapp.model.Account;
import com.example.dentalapp.model.Employee;
import com.example.dentalapp.repository.AccountRepository;
import com.example.dentalapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final WebSecurityConfig webSecurityConfig;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, WebSecurityConfig webSecurityConfig, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.webSecurityConfig = webSecurityConfig;
        this.employeeRepository = employeeRepository;
    }

    public Account getUserById(long userId){
        Optional<Account> optionalAccount = accountRepository.findById(userId);
        return optionalAccount.orElseThrow(() -> new ItemNotFoundException("Brak konta o id: " + userId));
    }

    public Account createAccount(Account account) {
        account.setPassword(webSecurityConfig.passwordEncoder().encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Transactional
    public Account editAccount(Account account, long accountId) {
        Account editedAccount = accountRepository.findAccountById(accountId);

        editedAccount.setId(accountId);
        editedAccount.setUsername(account.getUsername());
        editedAccount.setPassword(webSecurityConfig.passwordEncoder().encode(account.getPassword()));
        editedAccount.setRoles(account.getRoles());

        return editedAccount;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(long id){
        accountRepository.deleteById(id);
    }
}
