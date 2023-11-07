package com.muhittinu.controller;

import com.muhittinu.entitiy.Product;
import com.muhittinu.entitiy.ProductDetail;
import com.muhittinu.service.ProductDetailService;
import com.muhittinu.service.ProductService;
import com.muhittinu.util.BAUtils;

import java.util.Optional;

public class ProductDetailController {
    private final ProductDetailService productDetailService;
    private final ProductService productService;
    public ProductDetailController(){
        this.productDetailService = new ProductDetailService();
        this.productService = new ProductService();
    }
    public void showCommentsByProductId() {
        long productId = BAUtils.readInt("Goruntulenecek urun id'si ");
        Optional<Product> byId = productService.findById(productId);
        byId.get().getProductDetails().forEach(productDetail -> System.out.println(
                productDetail.getComment() + " " + productDetail.getScore()
        ));

    }
    public void commentAndRateProductById() {
        long productId = BAUtils.readInt("Yorum yapacaginiz urun id'si ");
        Product product = productService.findById(productId).get();
        String commentContent = BAUtils.readString("Yorumunuz ");
        double score = BAUtils.readDouble("Puaniniz ");
        ProductDetail productDetail = ProductDetail.builder()
                .comment(commentContent)
                .score(score)
                .product(product)
                .build();
        productDetailService.save(productDetail);
        System.out.println("Yorum ve Puaniniz Alindi.");
    }
}