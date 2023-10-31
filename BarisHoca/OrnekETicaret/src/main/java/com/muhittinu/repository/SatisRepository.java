package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Satis;
import com.muhittinu.utility.MyRepositoryFactory;

public class SatisRepository extends MyRepositoryFactory<Satis,Long> {

    public SatisRepository(Class<Satis> clazz) {
        super(Satis.class);
    }
}
