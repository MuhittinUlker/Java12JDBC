package com.muhittinu.service;

import com.muhittinu.entitiy.Adres;
import com.muhittinu.entitiy.Information;
import com.muhittinu.entitiy.Post;
import com.muhittinu.entitiy.User;
import com.muhittinu.entitiy.enums.EAdresType;
import com.muhittinu.entitiy.enums.ECinsiyet;
import com.muhittinu.entitiy.views.VwUsernameGenderPostCount;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private CriteriaBuilder criteriaBuilder;
    private Session session;
    private Transaction transaction;

    public UserService(){
        this.session = HibernateUtility.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        this.criteriaBuilder= session.getCriteriaBuilder();
    }
    public void save(){
        Information information = Information.builder().name("Hasan").surname("Ak").build();
        List<String> interests = Arrays.asList("Movie","Music");
        Adres evAdres =Adres.builder().country("Turkiye").city("Ankara").street("Etimesgut").build();
        Adres isAdres =Adres.builder().country("Turkiye").city("Ankara").street("Sincan").build();
        Map<String,Adres> adresler = new HashMap<>();
        adresler.put(EAdresType.HOME.name(),evAdres);
        adresler.put(EAdresType.BUSINESS.name(),isAdres);
        Information information2 = Information.builder().name("Mehmet").surname("Kaya").build();
        List<String> interests2 = Arrays.asList("Movie","Music");
        Adres evAdres2 =Adres.builder().country("Turkiye").city("Ankara").street("Cankaya").build();
        Adres isAdres2 =Adres.builder().country("Turkiye").city("Ankara").street("Kizilay").build();
        Map<String,Adres> adresler2 = new HashMap<>();
        adresler2.put(EAdresType.HOME.name(),evAdres2);
        adresler2.put(EAdresType.BUSINESS.name(),isAdres2);
        Information information3 = Information.builder().name("Ahmet").surname("Kara").build();
        List<String> interests3 = Arrays.asList("Music","Theater");
        Adres evAdres3 =Adres.builder().country("Turkiye").city("Ankara").street("Kizilcahamam").build();
        Adres isAdres3 =Adres.builder().country("Turkiye").city("Ankara").street("Kizilcahamam").build();
        Map<String,Adres> adresler3 = new HashMap<>();
        adresler3.put(EAdresType.HOME.name(),evAdres3);
        adresler3.put(EAdresType.BUSINESS.name(),isAdres3);
        Information information4 = Information.builder().name("Ayse").surname("Akar").build();
        List<String> interests4 = Arrays.asList("Game","SocialMedia");
        Adres evAdres4 =Adres.builder().country("Turkiye").city("Ankara").street("Cankaya").build();
        Adres isAdres4 =Adres.builder().country("Turkiye").city("Ankara").street("Bahcelievler").build();
        Map<String,Adres> adresler4 = new HashMap<>();
        adresler4.put(EAdresType.HOME.name(),evAdres4);
        adresler4.put(EAdresType.BUSINESS.name(),isAdres4);
        User user = User.builder().eCinsiyet(ECinsiyet.ERKEK).information(information).adresler(adresler).interests(interests).password("1234").username("hasanak").build();
        User user2 = User.builder().eCinsiyet(ECinsiyet.ERKEK).information(information2).adresler(adresler2).interests(interests2).password("1234").username("mehmetkaya").build();
        User user3 = User.builder().eCinsiyet(ECinsiyet.ERKEK).information(information3).adresler(adresler3).interests(interests3).password("1234").username("ahmetkara").build();
        User user4 = User.builder().eCinsiyet(ECinsiyet.KADIN).information(information4).adresler(adresler4).interests(interests4).password("1234").username("ayseakar").build();
        session.save(user);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        transaction.commit();
        session.close();
    }
    /*
        1- List<User> findAll()
        2- List<Information> findAllInformation
        3- List<String> findAllInformationName
        4- User findById
        5- List<User> findByUsername(String username)
        6- List<User> findByName(String name)
        7- ismi yine a ile başlayan postcountu 6 nın üzerinde olan kullanıcıları döndürerlim list dönsün
        8- toplam post sayısını bulalım tüm kullanıcıların post sayılarının toplamı. int dönsün
        9- En çok post atmış kişiyi döndürelim

        10- kullanıcıların username gender ve post count dönelim
        11- erkek ve kadın kullanıcı sayısını bulalım
     */
    public List<User> findAll(){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        List<User> resultList = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }
    public List<User> findAllHQL(){
        List<User> resultList = session.createQuery("FROM "+ User.class.getSimpleName(),User.class).getResultList();
        session.close();
        return resultList;
    }
    public List<User> findAllNativeQuery(){
        String sql = "SELECT * FROM tbl_users";
        List<User> resultList = session.createNativeQuery(sql, User.class).getResultList();
        session.close();
        return resultList;
    }
    public List<Information> findAllInformation(){
        CriteriaQuery<Information> criteriaQuery = criteriaBuilder.createQuery(Information.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root.get("information"));
        List<Information> resultList = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return resultList;
    }
    public List<String> findAllInformationName(){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root.get("information").get("name"));
        List<String> resultList = session.createQuery(criteriaQuery).getResultList();
        return  resultList;
    }
    public User findById(Long idparam){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate p1=criteriaBuilder.equal(root.get("id"),idparam);
        criteriaQuery.select(root).where(p1);
        User singleResult = session.createQuery(criteriaQuery).getSingleResult();
        return singleResult;
    }

    public User findByUsername(String username){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate p1=criteriaBuilder.like(root.get("username"),username);
        criteriaQuery.select(root).where(p1);
        User singleResult = session.createQuery(criteriaQuery).getSingleResult();
        return singleResult;
    }
    public List<User> findByName(String name){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate p1=criteriaBuilder.like(root.get("information").get("name"),name);
        criteriaQuery.select(root).where(p1);
        List<User> resultList = session.createQuery(criteriaQuery).getResultList();
        return  resultList;
    }
    public List<User> findByNameAndPostCount(String name,Long postCount){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<Post> postRoot = subquery.from(Post.class);
        subquery.select(criteriaBuilder.count(postRoot.get("id")));
        subquery.where(criteriaBuilder.equal(postRoot.get("userId"),root.get("id")));
        criteriaQuery.select(root).where(criteriaBuilder.greaterThanOrEqualTo(subquery,postCount),
                criteriaBuilder.like(root.get("information").get("name"),name));
        List<User> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;
    }
    public Integer allPostsCount(){
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(criteriaBuilder.count(root.get("id")));
        Long singleResult = session.createQuery(criteriaQuery).getSingleResult();
        String deger = Long.toString(singleResult);
        int sonuc = Integer.parseInt(deger);
        return sonuc;
    }
//    public User findUserWithMostPosts(){
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> userRoot = criteriaQuery.from(User.class);
//        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
//        Root<Post> postRoot = subquery.from(Post.class);
//        subquery.select(criteriaBuilder.count(postRoot.get("id")));
//        subquery.where(criteriaBuilder.equal(postRoot.get("userId"), userRoot));
//        criteriaQuery.select(userRoot);
//        criteriaQuery.where(criteriaBuilder.max(postRoot.get()));
//        User user = session.createQuery(criteriaQuery).getSingleResult();
//        return user;
//    }
    public List<VwUsernameGenderPostCount> listUsernameGenderPostcount(){
        CriteriaQuery<VwUsernameGenderPostCount> criteriaQuery = criteriaBuilder.createQuery(VwUsernameGenderPostCount.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        return null;
    }
}
