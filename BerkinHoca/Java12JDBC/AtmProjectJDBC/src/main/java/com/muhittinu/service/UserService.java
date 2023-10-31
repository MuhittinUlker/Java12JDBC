package com.muhittinu.service;

import com.muhittinu.entity.User;
import com.muhittinu.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    public UserService(){
        this.userRepository = new UserRepository();
    }
    public User login(String email,String password){
        return userRepository.login(email,password);
    }
}
