package com.muhittinu.service;

import com.muhittinu.entitiy.Product;
import com.muhittinu.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(){
        this.productRepository = new ProductRepository();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> buyProduct(long productId, int amount) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            if (optionalProduct.get().getStock()>=amount){
                return optionalProduct;
            }else {
                System.out.println("Yetersiz Stok");
            }
        }else {
            System.out.println("Product Bulunamadi");
        }
        return Optional.empty();
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public List<Product> listAll() {
       return productRepository.findAll();
    }

    public Optional<Product> findById(long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> listLowStockProducts() {
        return productRepository.listLowStockProducts();
    }
}
