package com.muhittinu.controller;

import com.muhittinu.entitiy.Person;
import com.muhittinu.service.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class PersonController {

    private final PersonService personService;

    public PersonController(){
        personService=new PersonService();
    }
    public void register(Person person){
        personService.register(person);
    }

    public void getAll() {
       personService.getAll();
    }

    public void clearAll(String tableName) {
        personService.clearAll(tableName);
    }

    public void update(String oldMail, String newMail) {
        personService.update(oldMail,newMail);
    }

    public void findById(int idargs) {
        personService.findById(idargs);
    }

    public void deleteById(String tableName,int idargs) {
        personService.deleteById(tableName, idargs);
    }
}
