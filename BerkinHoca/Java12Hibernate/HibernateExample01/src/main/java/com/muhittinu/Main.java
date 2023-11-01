package com.muhittinu;

import com.muhittinu.entitiy.Adres;
import com.muhittinu.entitiy.Post;
import com.muhittinu.entitiy.enums.EAdresType;
import com.muhittinu.entitiy.Information;
import com.muhittinu.entitiy.User;
import com.muhittinu.service.PostService;
import com.muhittinu.service.UserService;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Information information = Information.builder().name("Muhittin").surname("Ulker").build();
        List<String> interests = Arrays.asList("Book","Comics");
        Adres evAdres =Adres.builder().country("Turkiye").city("Ankara").street("Etimesgut").build();
        Adres isAdres =Adres.builder().country("Turkiye").city("Ankara").street("Sincan").build();
        Map<String,Adres> adresler = new HashMap<>();
        adresler.put(EAdresType.HOME.name(),evAdres);
        adresler.put(EAdresType.BUSINESS.name(),isAdres);
        User user = User.builder().information(information).adresler(adresler).interests(interests).password("1234").username("muhittinulker").build();
        UserService userService = new UserService();
        userService.save(user);

        PostService postService = new PostService();
        postService.createPost();
    }


}