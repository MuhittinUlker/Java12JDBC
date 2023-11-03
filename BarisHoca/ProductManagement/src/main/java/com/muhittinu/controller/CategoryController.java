package com.muhittinu.controller;

import com.muhittinu.entitiy.Category;
import com.muhittinu.service.CategoryService;
import com.muhittinu.util.BAUtils;

import java.util.Optional;

public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(){
        categoryService = new CategoryService();
    }
    public void save() {
        String categoryName = BAUtils.readString("Category Name:");
        Category category = Category.builder().name(categoryName).build();
        categoryService.save(category);
    }

    public Optional<Category> findById(long productId) {
        return categoryService.findById(productId);
    }
}
