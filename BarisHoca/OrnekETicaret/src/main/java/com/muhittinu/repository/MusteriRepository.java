package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Musteri;
import com.muhittinu.utility.MyRepositoryFactory;

public class MusteriRepository extends MyRepositoryFactory<Musteri,Long> {

    public MusteriRepository(Class<Musteri> clazz) {
        super(Musteri.class);
    }
}
