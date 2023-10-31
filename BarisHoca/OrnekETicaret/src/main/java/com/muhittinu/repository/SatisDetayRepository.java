package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.SatisDetay;
import com.muhittinu.utility.MyRepositoryFactory;

public class SatisDetayRepository extends MyRepositoryFactory<SatisDetay,Long> {

    public SatisDetayRepository(Class<SatisDetay> clazz) {
        super(SatisDetay.class);
    }
}
