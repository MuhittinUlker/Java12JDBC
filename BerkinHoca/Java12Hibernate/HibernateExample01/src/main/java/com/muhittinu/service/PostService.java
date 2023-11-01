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
        Post post2 = Post.builder().content("Superr").date(new Date()).userId(1L).build();
        Post post3 = Post.builder().content("Harikaaa").date(new Date()).userId(1L).build();
        Post post4 = Post.builder().content("Java").date(new Date()).userId(1L).build();
        Post post5 = Post.builder().content("BilgeAdam").date(new Date()).userId(1L).build();
        Post post6 = Post.builder().content("Hibernate").date(new Date()).userId(1L).build();
        Post post7 = Post.builder().content("Selaam").date(new Date()).userId(1L).build();
        Post post8 = Post.builder().content("Hello").date(new Date()).userId(2L).build();
        Post post9 = Post.builder().content("PostgreSQL").date(new Date()).userId(3L).build();
        Post post10= Post.builder().content("JPA").date(new Date()).userId(4L).build();

        session.save(post);
        session.save(post2);
        session.save(post3);
        session.save(post4);
        session.save(post5);
        session.save(post6);
        session.save(post7);
        session.save(post8);
        session.save(post9);
        session.save(post10);
        transaction.commit();
        session.close();
    }
}
