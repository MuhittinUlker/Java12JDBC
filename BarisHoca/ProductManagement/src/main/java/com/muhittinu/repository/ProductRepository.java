package com.muhittinu.repository;

import com.muhittinu.entitiy.Product;
import com.muhittinu.util.MyRepositoryFactory;

public class ProductRepository extends MyRepositoryFactory<Product,Long> {
    public ProductRepository() {
        super(Product.class);
    }
}
