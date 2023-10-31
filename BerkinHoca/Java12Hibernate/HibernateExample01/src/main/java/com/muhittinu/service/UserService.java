package com.muhittinu.service;

import com.muhittinu.entitiy.User;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    public void save(User user){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
