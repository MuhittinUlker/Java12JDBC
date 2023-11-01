package com.muhittinu.criteriaornekler;

import com.muhittinu.repository.entitiy.Musteri;
import com.muhittinu.repository.entitiy.Urun;
import com.muhittinu.repository.views.VwUrun;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class CriteriaOrnekleri {
    Session session;
    CriteriaBuilder criteriaBuilder;
    public CriteriaOrnekleri() {
        session= HibernateUtility.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
    }
    /*
        Sorgu1: SELECT * FROM tblmusteri -> musterilerden olusan bir liste donecek.

     */
    public List<Musteri> findAll(){
        /*
            Kriter tanimlanirken kullanilacak sinifin adini vererek isleme baslariz.
            Bu sinif .class olarak verilmelidir.
            Reflection API sayesinde arka polanda o class icindeki tum fieldlar belirlenir.
         */
        CriteriaQuery<Musteri> criteriaQuery = criteriaBuilder.createQuery(Musteri.class);
        /*
            Sorgunun atilacagi tabliyo belirleyelim.
         */
        Root<Musteri> root = criteriaQuery.from(Musteri.class);
        /*
            Sorguda hangi alanlar secilecek onu onu tanimlamaliyiz. " select(root) = SELECT * "
         */
        criteriaQuery.select(root);
        /*
            Sorgunuz hazir olduktan sonra bunu calistirmalisiniz.
         */
        List<Musteri> resultList = session.createQuery(criteriaQuery).getResultList();
        /*
            Sonuclari donelim.
         */
        return resultList;
    }
    /*
        Sorgu2: SELECT ad FROM tblmusteri -> Stringlerden olusan bir liste doner
     */
    public List<String> selectOneColumn(){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        criteriaQuery.select(root.get("ad"));
        List<String> resultList = session.createQuery(criteriaQuery).getResultList();
        return  resultList;
    }
    /*
        Sorgu3: SELECT ad FROM tblurun WHERE id=? String doner.
     */
    public String selectOneColumnById(Long idparametre){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1=criteriaBuilder.equal(root.get("id"),idparametre);
        criteriaQuery.select(root.get("ad")).where(p1);
        String singleResult = session.createQuery(criteriaQuery).getSingleResult();
        return singleResult;
    }
    /*
        Sorgu4: SELECT * FROM tblurun WHERE id=?
     */
    public Urun findById(Long idparametre){
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1=criteriaBuilder.equal(root.get("id"),idparametre);
        criteriaQuery.select(root).where(p1);
        Urun singleResult = session.createQuery(criteriaQuery).getSingleResult();
        return singleResult;
    }
    /*
        Sorgu5: SELECT id,ad,fiyat FROM tblurun Object[] veya tuple dondurebiliriz
     */
    public List<Object[]> selectManyColumn(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Path<Long> pathId = root.get("id");
        Path<String> pathAd = root.get("ad");
        Path<BigDecimal> pathFiyat = root.get("fiyat");
        //criteriaQuery.select(criteriaBuilder.array(pathId,pathAd,pathFiyat));
        criteriaQuery.multiselect(pathId,pathAd,pathFiyat);
        return session.createQuery(criteriaQuery).getResultList();
    }
    /*
        Sorgu6: SELECT * FROM tblurun WHERE ad LIKE '%r%' AND fiyat>15
     */
    public List<Urun> findAllByNameAndFiyatGt(String urunAd,BigDecimal fiyat){
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1 = criteriaBuilder.like(root.get("ad"),urunAd);
        Predicate p2 = criteriaBuilder.greaterThan(root.get("fiyat"),fiyat);
        Predicate sonKosul = criteriaBuilder.and(p1,p2);
        criteriaQuery.select(root).where(sonKosul);
        return session.createQuery(criteriaQuery).getResultList();
    }
    /**
     * Native Query yazimi: SQL kodlari ile JPA(Hibernate) uzerinden sorgulama yapabilirisiniz
     *
     * Eger direkt sorguyu yazip birakirsaniz geriye Object[] doner
     * Gidip tip belirtmek yeterli
     */
    public List<Urun> findAllNativeQuery(){
        List<Urun> resultList = session.createNativeQuery("SELECT * FROM tblurun", Urun.class).getResultList();
        return resultList;
    }
    public List<VwUrun> findAllNativeQuery2(){
        List<VwUrun> resultList = session.createNativeQuery("SELECT id,ad FROM tblurun", VwUrun.class).getResultList();
        return resultList;
    }
    /*
        NamedQuery
        Kullanilacak dil JPQL yada HQL
        Entity uzerine yazilir
        SQL -> SELECT * FROM tblmusteri
        **JPQL** -> SELECT m FROM Musteri m
        HQL -> FROM Musteri
     */
    public List<Urun> findAllNamedQuery(){
        List<Urun> resultList = session.createNamedQuery("Urun.findAll", Urun.class).getResultList();
        return resultList;
    }
    public List<Urun> findAllByNameNamedQuery(String urunAd){
        Query<Urun> namedQuery = session.createNamedQuery("Urun.findByName", Urun.class);
        namedQuery.setParameter("urunad",urunAd);
        return namedQuery.getResultList();
    }
}
