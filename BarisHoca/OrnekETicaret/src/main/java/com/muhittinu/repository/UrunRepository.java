package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Urun;
import com.muhittinu.utility.MyRepositoryFactory;

public class UrunRepository extends MyRepositoryFactory<Urun,Long> {
    public UrunRepository(Class<Urun> clazz) {
        super(Urun.class);
    }
}
