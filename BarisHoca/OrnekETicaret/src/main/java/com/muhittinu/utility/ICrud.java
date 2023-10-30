package com.muhittinu.utility;

import java.util.List;

public interface ICrud <T>{
    void save(T entity);
    void update(T entity);
    void delete(Long id);
    List<T> findAll();
    T findById(Long id);
}
