package com.example.dentalapp.service;

import com.example.dentalapp.config.WebSecurityConfig;
import com.example.dentalapp.exception.ItemNotFoundException;
import com.example.dentalapp.model.Account;
import com.example.dentalapp.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final WebSecurityConfig webSecurityConfig;

    public AccountService(AccountRepository accountRepository, WebSecurityConfig webSecurityConfig) {
        this.accountRepository = accountRepository;
        this.webSecurityConfig = webSecurityConfig;
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
    public Account editAccount(Account account) {
        Account editedAccount = new Account();

        editedAccount.setId(account.getId());
        editedAccount.setUsername(account.getUsername());
        editedAccount.setPassword(account.getPassword());
        editedAccount.setRoles(account.getRoles());

        return editedAccount;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
