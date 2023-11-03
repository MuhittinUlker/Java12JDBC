package com.muhittinu.service;

import com.muhittinu.entitiy.Category;
import com.muhittinu.repository.CategoryRepository;

import java.util.Optional;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(){
        this.categoryRepository = new CategoryRepository();
    }
    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findById(long productId) {
        return categoryRepository.findById(productId);
    }
}
