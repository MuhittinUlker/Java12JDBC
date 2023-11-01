package com.muhittinu.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class MyRepositoryFactory<T,ID> implements  ICrud<T, ID>{
    Class<T> clazz;
    public MyRepositoryFactory(Class<T> clazz){
        this.clazz=clazz;
    }
    private Session session;
    private Transaction transaction;
    private CriteriaBuilder criteriaBuilder;
    private void openSession() {
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    private void closeSession() {
        transaction.commit();
        session.close();
    }
    @Override
    public T save(T entity) {
        openSession();
        session.save(entity);
        closeSession();
        return entity;
    }
    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        openSession();
        entities.forEach(entity->{
            session.save(entity);
        });
        closeSession();
        return entities;
    }
    @Override
    public T update(T entity) {
        openSession();
        //session.update(entitiy); void oldugu icin JPA merge() kullanabiliriz
        T merge = (T)session.merge(entity);
        closeSession();
        return merge;
    }
    @Override
    public void deleteById(ID id)  {
        openSession();
        session.delete(session.get(clazz, (Serializable) id));
        closeSession();
    }
    @Override
    public void delete(T entity) {
        openSession();
        session.delete(entity);
        closeSession();
    }
    @Override
    public Optional<T> findById(ID id) {
        openSession();
        Optional<T> obj = Optional.ofNullable(session.get(clazz, (Serializable) id));
        closeSession();
        return obj;
    }
    @Override
    public boolean existsById(ID id) {
        return findById(id).isPresent();
    }
    @Override
    public List<T> findAll() {
        openSession();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        closeSession();
        return resultList;
    }
    @Override
    public <E> List<T> findByColumnNameAndValue(String columnName, E value) {
        openSession();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName() + " WHERE " + columnName + " = :value", clazz)
                .setParameter("value", value).getResultList();
        closeSession();
        return resultList;
    }
    /**
     * findByEntity metodu ile yapilmak istenen: Bir sinif icindeki alanlarin metod tarafindan
     * okunulmasi ve her bir alanin icindeki degerlerin kontrol edilerek
     * null olmayanlari sorguya dahil etmesidir
     * Boylece esnek sorgulama sistemi kazandirilmaya calisilacaktir
     * Bu islemin adina REVERSE ENGINEERING denir.
     * Burada REFLECTION API kullanilabilir
     */
    @Override
    public List<T> findByEntity(T entity) {
        openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields(); //sinif icindeki tum fieldlari dizi olarak doner
        for (Field field:fields) {
            field.setAccessible(true);//field'i erisime acmak icin
            try {
                Object value = field.get(entity);
                if (value!=null & !field.getName().equals("id")){
                    if (field.getType().isAssignableFrom(Number.class)){
                        predicates.add(criteriaBuilder.equal(root.get(field.getName()),value));
                    }
                    if (field.getType().isAssignableFrom(String.class)) {
                        predicates.add(criteriaBuilder.like(root.get(field.getName()), (String) value));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
        List<T> resultList = session.createQuery(criteriaQuery).getResultList();
        closeSession();
        return resultList;
    }
}
