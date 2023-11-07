package com.muhittinu.repository;

import com.muhittinu.entitiy.Product;
import com.muhittinu.util.HibernateUtility;
import com.muhittinu.util.MyRepositoryFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepository extends MyRepositoryFactory<Product,Long> {
    public ProductRepository() {
        super(Product.class);
    }

    public List<Product> listLowStockProducts() {
        openSession();
        CriteriaQuery<Product> criteriaQuery = getCriteriaBuilder().createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root).where(getCriteriaBuilder().lessThanOrEqualTo(root.get("stock"),10));
        List<Product> resultList = getSession().createQuery(criteriaQuery).getResultList();
        closeSession();
        return resultList;
    }
}
