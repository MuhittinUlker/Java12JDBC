# **ORM NEDIR?**
## Object Relational Mapping = Nesne Iliskisel Eslestirme
OOP dillerle veritabani arasindaki farkli yapilari eslestirmekte
kullanilan bir tekniktir. 
ORM ile veri tabani icindek itablolar nesneler ile iliskilendirilir.
Boylece vt islemlerini nesne odakli bir sekilde yapabiliriz.

ORM kullansakta yine driver'a ihtiyacimiz olacak.

Nesneler araciligi ile veritabanindaki tablolara
* ekleme
* silme
* guncelleme
* listeleme
* tablolar arasi iliskiler
    * one-to-one
    * one-to-many
    * many-to-one
    * many-to-many
* PK, Sequence,

PostgreSQL de tek yapacagimiz sey vertabani acmak.

ORM araclari ile siz kolayca vt degistirebilirsiniz.
VT bagimsizligi kazandirir.

## Avantajlari:
* Yazilim gelistirme surecimizi kisaltir
* VT sorgualri ile ilgili detaylarla ugrasmak zorunda kalmayiz

## Dezavantajlari:
* Performansi JDBC'den bir tik yavastir.
* Ogrenme egrisi karmasiktir.
* Arka planda karmasik bir yapisi var.

## JPA: JavaPersistenceAPI -> JakartaPersistenceAPI
JDO,JBAF

## ORM Araclari
* Hibernate (Java icin en populer)
* EclipseLink
* OpenJPA

| JDBC                               | HIBERNATE                                              |
|------------------------------------|--------------------------------------------------------|
| Low-Level SQL Komutlarini kullanir | Arka planda JDCB kullanir ve sizi o katmandan soyutlar |
| **SQL**                            | **SQL** + **HQL** + **JPQL**                           |
| Nesne-Tablo arasindaki iliskiyi manuel olarak yapmistik. | Otomatik yapilir                 |
 | VT'a direkt olarak baglidir | VT bagimliligini ortadan kaldirir |
| Cacheleme yok | Cache yapisi var. |
| Kodlar SQL ile karmasiklasabilir | Cok daha basit sorgular yazilabilir veya hazir metodlari kullanilir |

## ORM Araci (Hibernate)
Sen bana bilgileri ver. (AdresBilgisi, PortBilgisi, VTBilgisi, username,password)
 * Ben baglanti kurarim
 * Butun temel islemlerini yapacak hazir metodlarimi kullanabilirsin.
 * Bu yuzden hibernate icin yapilandirma dosyalari cok onemlidir.

Hibernate 6 surumunden once JavaPersistenceAPI kullanir
6 ve uzeri surumlerde JakartaPersistenceAPI kullanir

API? Application Programming Interface

## Javada direkt olarak JPA kullanilabilir mi?
Hayir, interface'i direkt olarak kullanamazsiniz.
