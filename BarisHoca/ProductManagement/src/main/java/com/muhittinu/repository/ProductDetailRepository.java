package com.muhittinu.repository;

import com.muhittinu.entitiy.Product;
import com.muhittinu.entitiy.ProductDetail;
import com.muhittinu.util.MyRepositoryFactory;

public class ProductDetailRepository extends MyRepositoryFactory<ProductDetail,Long> {
    public ProductDetailRepository() {
        super(ProductDetail.class);
    }
}
