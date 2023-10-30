package com.muhittinu;

import com.muhittinu.entitiy.Person;
import com.muhittinu.repository.PersonRepository;
import com.muhittinu.util.JDBCHelper;
import com.muhittinu.util.Menu;

import java.sql.Connection;
import java.util.Optional;

/*
    1-personDB olusturalim= id,first_name,last_name,joinedDate
    2-util paketinde jdbchelper diye bir class olusturalim
    getConnection() metodu olsun, bu metod bize connection donsun
    3-Buradaki db bilgilerini farkli bir classtan cekelim
    4-register islemi
    kullanicidan isim soyisim email alicaz ve db'ye kaydedicez
    ilk repository katmanini yazacagiz
 */
public class Main {
    public static void main(String[] args) {
       Menu menu = new Menu();
       menu.Menu();
    }
}