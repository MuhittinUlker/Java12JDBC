package com.muhittinu.service;

import com.muhittinu.entitiy.Post;
import com.muhittinu.entitiy.User;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class PostService {
    public void createPost(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = Post.builder().content("Harika bir gun").date(new Date()).userId(1L).build();
        session.save(post);
        transaction.commit();
        session.close();
    }
}
