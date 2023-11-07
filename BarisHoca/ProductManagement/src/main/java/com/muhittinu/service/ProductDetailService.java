package com.muhittinu.service;

import com.muhittinu.entitiy.ProductDetail;
import com.muhittinu.repository.ProductDetailRepository;

import java.util.List;

public class ProductDetailService {
    private final ProductDetailRepository productDetailRepository;
    public ProductDetailService(){
        this.productDetailRepository = new ProductDetailRepository();
    }

    public void update(ProductDetail productDetail) {
        productDetailRepository.update(productDetail);
    }

    public List<ProductDetail> findByColumnNameAndValue(String product, long productId) {
        return productDetailRepository.findByColumnNameAndValue(product,productId);
    }

    public void save(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }
}
