package com.muhittinu.repository;

import com.muhittinu.entitiy.Category;
import com.muhittinu.util.MyRepositoryFactory;

public class CategoryRepository extends MyRepositoryFactory<Category,Long> {
    public CategoryRepository() {
        super(Category.class);
    }
}
