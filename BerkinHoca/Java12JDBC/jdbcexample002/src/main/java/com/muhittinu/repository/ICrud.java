package com.muhittinu.repository;

import java.sql.ResultSet;
import java.util.Optional;

public interface ICrud <T>{
    void save(T t);
    void getAll();
    void clearAll(String tableName);
    void deleteById(String tableName,int idargs);
    void findById(int idargs);
    void update(String oldData,String newData);
}
