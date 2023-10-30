package com.muhittinu;

import com.muhittinu.entitiy.Musteri;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//Java12HibernateDB
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        Musteri m1 = new Musteri(1,"Ozan","Celik","Oxford");
//        session.save(m1);
//        session.update(m1);

//        Musteri arananMusteri = session.get(Musteri.class, 1);
//        arananMusteri.setAdres("Yozgat");
//        arananMusteri.setSoyad("Yoz");
//        session.update(arananMusteri);

//        Musteri silinecekMusteri = session.get(Musteri.class, 1);
//        session.delete(silinecekMusteri);

//        Musteri m1 = new Musteri("Berre","Gul","Dublin");
//        session.save(m1);

        Criteria criteria = session.createCriteria(Musteri.class); //geri donecek tipi yaziyoruz
        List<Musteri> musteriList = criteria.list();

        transaction.commit();
        session.close();

        musteriList.forEach(System.out::println);
    }
}