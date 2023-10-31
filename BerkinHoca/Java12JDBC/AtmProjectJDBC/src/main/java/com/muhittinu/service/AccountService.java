package com.muhittinu.service;

import com.muhittinu.entity.Account;
import com.muhittinu.entity.TransferDekont;
import com.muhittinu.entity.User;
import com.muhittinu.repository.AccountRepository;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public void createAccount(User user){
        System.out.println("Hesap olusturuldu "+ accountRepository.createAccount(user));
    }
    public void getAccountsByEmail(String email){
        List<Account> accountList = accountRepository.getAccountsByEmail(email);
        accountList.forEach(System.out::println);
    }
    public void transferMoney(int amount, String accountNo,User user){
        TransferDekont transferDekont = accountRepository.transferMoney(amount, accountNo, user);
        System.out.println(transferDekont);
    }
}
