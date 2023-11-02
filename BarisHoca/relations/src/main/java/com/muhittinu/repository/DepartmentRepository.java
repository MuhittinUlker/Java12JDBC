package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Department;
import com.muhittinu.utility.MyRepositoryFactory;

public class DepartmentRepository extends MyRepositoryFactory<Department,Long> {
    public DepartmentRepository() {
        super(Department.class);
    }
}
