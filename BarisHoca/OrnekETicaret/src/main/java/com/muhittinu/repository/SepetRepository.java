package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Sepet;
import com.muhittinu.utility.MyRepositoryFactory;

public class SepetRepository extends MyRepositoryFactory<Sepet,Long> {

    public SepetRepository(Class<Sepet> clazz) {
        super(Sepet.class);
    }
}
