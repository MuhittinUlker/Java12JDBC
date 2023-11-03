package com.muhittinu.controller;

import com.muhittinu.entitiy.Category;
import com.muhittinu.entitiy.Customer;
import com.muhittinu.entitiy.Product;
import com.muhittinu.repository.ProductRepository;
import com.muhittinu.service.CategoryService;
import com.muhittinu.service.ProductService;
import com.muhittinu.util.BAUtils;

import java.util.Optional;

public class ProductController {
    private final ProductService productService;
    private final CategoryController categoryController;
    public ProductController(){
        this.productService = new ProductService();
        this.categoryController = new CategoryController();
    }
    public void save() {
        String name = BAUtils.readString("Product Name");
        double price = BAUtils.readDouble("Product Price");
        int stock = BAUtils.readInt("Product Stock");
        long productId = BAUtils.readInt("Category ID");
        Optional<Category> optionalCategory = categoryController.findById(productId);
        Product product = Product.builder().name(name).price(price).stock(stock).category(optionalCategory.get()).build();
        productService.save(product);
    }

    public void buyProduct(Customer customer) {
        long productId = BAUtils.readInt("Almak istediginiz urun id girin");
        int amount = BAUtils.readInt("Kac adet almak istiyorsunuz");
        Optional<Product> product = productService.buyProduct(productId,amount);
        product.get().getCustomers().add(customer);
        product.get().setStock(product.get().getStock()-amount);
        productService.update(product.get());
    }
}
