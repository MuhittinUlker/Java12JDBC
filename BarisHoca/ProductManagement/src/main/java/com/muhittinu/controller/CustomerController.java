package com.muhittinu.controller;

import com.muhittinu.entitiy.Customer;
import com.muhittinu.entitiy.Information;
import com.muhittinu.service.CustomerService;
import com.muhittinu.util.BAUtils;

import java.util.Optional;

public class CustomerController {
private final CustomerService customerService;
    public CustomerController(){
        this.customerService = new CustomerService();
    }
    public void register(){
        String firstName = BAUtils.readString("Isminiz: ");
        String lastName = BAUtils.readString("Soyisminiz: ");
        String email = BAUtils.readString("Email: ");
        Information information = Information.builder().firstName(firstName).lastName(lastName).email(email).build();
        String password = BAUtils.readString("Sifreniz: ");
        String identityNo = BAUtils.readString("T.C.: ");
        Customer customer = Customer.builder().information(information).password(password).identity(identityNo).build();
        customerService.register(customer);
    }

    public Customer login() {
        String identitiyNo = BAUtils.readString("T.C.iz: ");
        String password = BAUtils.readString("Sifreniz: ");
        return customerService.findCustomerByIdentity(identitiyNo,password).get();
    }
}
