package com.muhittinu.repository;

import com.muhittinu.entitiy.Customer;
import com.muhittinu.util.MyRepositoryFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class CustomerRepository extends MyRepositoryFactory<Customer,Long> {
    public CustomerRepository() {
        super(Customer.class);
    }

    public Optional<Customer> findCustomerByIdentitiy(String identitiyNo) {
       openSession();
        CriteriaQuery<Customer> criteriaQuery = getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(getCriteriaBuilder().equal(root.get("identity"),identitiyNo));
        List<Customer> resultList = getSession().createQuery(criteriaQuery).getResultList();
        closeSession();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }
}
