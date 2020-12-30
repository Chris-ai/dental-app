package com.example.dentalapp.controller;

import com.example.dentalapp.model.Account;
import com.example.dentalapp.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable long id){
        return accountService.getUserById(id);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PutMapping("/accounts/{id}")
    public Account editAccount(@PathVariable long id, @RequestBody Account account){
        return accountService.editAccount(account,id);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
    }
}
