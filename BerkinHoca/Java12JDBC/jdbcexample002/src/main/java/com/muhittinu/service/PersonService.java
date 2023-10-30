package com.muhittinu.service;

import com.muhittinu.entitiy.Person;
import com.muhittinu.repository.PersonRepository;

import java.sql.ResultSet;
import java.util.Optional;

public class PersonService {
    private final PersonRepository personRepository;
    public PersonService(){
        personRepository=new PersonRepository();
    }
    public void register(Person person){
        personRepository.register(person);
    }

    public void getAll() {
        personRepository.getAll();
    }

    public void clearAll(String tableName) {
        personRepository.clearAll(tableName);
    }

    public void update(String oldMail, String newMail) {
        personRepository.update(oldMail,newMail);
    }

    public void findById(int idargs) {
        personRepository.findById(idargs);
    }

    public void deleteById(String tableName,int idargs) {
        personRepository.deleteById(tableName,idargs);
    }
}
