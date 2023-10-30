package com.muhittinu.entitiy;

import javax.persistence.*;
/*
    @GeneratedValue Strategy'leri
    1- IDENTITY: 1'den baslar ve her kayit geldiginde otomatik olarak 1 arttirilir
    2- SEQUENCE:
        olusturma:  @SequenceGenerator(name = "seq1", sequenceName = "tblmusteri_id_seq",initialValue = 10,allocationSize = 2)
        atama: @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")
    3- AUTO: Veritabani bazinda tek sequence olusturur. Onunla deger arttirimi saglar.
    4- TABLE: Sequence'ler icin tablo olusturur.

    Yapilmasi gerkenler:
    -Bos constructor
    -Id'siz dolu constructor
    -Dolu constructor
    -GetterSetter
    -toString

    Sinifa @Entity belirtildikten sonra
    cfg.xml dosyamiza <session-factory> icerisine <mapping class="com.muhittinu.entitiy.Musteri"/>
    eklenmelidir.

     */
@Entity
@Table(name = "tblmusteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String ad;
    String soyad;
    String adres;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public Musteri(int id, String ad, String soyad, String adres) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
