package com.muhittinu;

import com.muhittinu.entity.User;
import com.muhittinu.service.AccountService;
import com.muhittinu.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        User user = userService.login("ahmet@gmail.com","12345");
        System.out.println("Hosgeldiniz "+user.getName());

        accountService.transferMoney(1000,"2246626071",user);
    }
}