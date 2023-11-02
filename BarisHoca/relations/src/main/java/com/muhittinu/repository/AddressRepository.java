package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Address;
import com.muhittinu.utility.MyRepositoryFactory;

public class AddressRepository extends MyRepositoryFactory<Address,Long> {
    public AddressRepository() {
        super(Address.class);
    }
}
