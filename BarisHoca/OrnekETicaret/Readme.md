# Hibernate ile adim adim proje olusturma

1. VT sunucusunda bir VT olustur (Java12OrnekETicaret)
2. Package'lari olusturalim
3. Resources package'i icine config dosyasini at
4. hibernate.cfg.xml dosyasinda gerekli degisiklikleri yap
5. build.gradle dosyasina dependencies'leri ekle
6. gerekli entitiyleri yaz(Sepet,Urun)
7. Entityler icin
   1. (bos constructor)
   2. id'siz dolu
   3. dolu const
   4. getter & setter
   5. toString
8. config dosyasinda mapping islemini yap
9. utility package icine HibernateUtility.java dosyasini ekle

# Kullanim adimlari
1. Session olustur
   1. Session session = HibernateUtility.getSessionFactory().openSession();
   2.  session.close();
2. Transaction olustur ve baslat
   1. Transaction transaction = session.beginTransaction();
   2. transaction.commit();
3.CRUD islemlerini yap.

# Turkce karakter sorunu icin:
build.gradle icerisine:
   tasks.withType(JavaCompile).configureEach{
   options.encoding='UTF-8'}

# Lombok kullanilan anotassyonlar
@NoArgsConstructor //bos constructor olusturur
@AllArgsConstructor //dolu constructor
@Data // getter setter toString...