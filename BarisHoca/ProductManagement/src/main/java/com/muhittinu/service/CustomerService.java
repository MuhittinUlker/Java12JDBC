package com.muhittinu.service;

import com.muhittinu.entitiy.Customer;
import com.muhittinu.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(){
        customerRepository = new CustomerRepository();
    }
    public void register(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerByIdentity(String identitiyNo,String password) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByIdentitiy(identitiyNo);
        if (optionalCustomer.isPresent()){
            if (optionalCustomer.get().getPassword().equals(password)){
                return optionalCustomer;
            }else {
                System.out.println("Password is Not Valid");
            }
        }else {
            System.out.println("Customer Not Found");
        }
        return Optional.empty();
    }
}
