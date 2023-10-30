package com.muhittinu.repository;

import java.util.List;

public interface ICrud <T>{
    void saveAll(List<T> t);
    void save(T t);
    void update(T t,int id);
    List<T> findAll();
}
