package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Personel;
import com.muhittinu.utility.MyRepositoryFactory;

public class PersonelRepository extends MyRepositoryFactory<Personel,Long> {
    public PersonelRepository() {
        super(Personel.class);
    }
}
