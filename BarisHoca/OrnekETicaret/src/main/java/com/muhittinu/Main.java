package com.muhittinu;

import com.muhittinu.criteriaornekler.CriteriaOrnekleri;
import com.muhittinu.enums.ECinsiyet;
import com.muhittinu.repository.UrunRepository;
import com.muhittinu.repository.entitiy.*;
import com.muhittinu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        BaseEntitiy baseEntitiy = BaseEntitiy.builder().durum(1).olusturmaTarihi(System.currentTimeMillis()).guncellemeTarihi(System.currentTimeMillis()).build();
//
//        Urun urunSeker = Urun.builder().ad("Seker").fiyat(BigDecimal.valueOf(20)).stok(100).baseEntitiy(baseEntitiy).build();
//        Urun urunUn = Urun.builder().ad("Un").fiyat(BigDecimal.valueOf(40)).stok(100).baseEntitiy(baseEntitiy).build();
//        Urun urunBilgisayar = Urun.builder().ad("Bilgisayar").fiyat(BigDecimal.valueOf(25000)).stok(5).baseEntitiy(baseEntitiy).build();
//
//        UrunRepository urunRepository = new UrunRepository();
//
//        urunRepository.save(urunSeker);
//        urunRepository.save(urunUn);
//        urunRepository.save(urunBilgisayar);

//      session.save(urunSeker);
//      session.save(urunUn);
//      Satis satis = Satis.builder().musteriid(1L).tarih(System.currentTimeMillis()).baseEntitiy(baseEntitiy).toplamtutar(BigDecimal.valueOf(500)).build();
//      session.save(satis);
//      SatisDetay satisDetaySeker = SatisDetay.builder().urunid(1L).fiyat(BigDecimal.valueOf(20)).adet(5).toplamFiyat(BigDecimal.valueOf(100)).satisid(1L).build();
//      session.save(satisDetaySeker);
//      SatisDetay satisDetaUn = SatisDetay.builder().urunid(2L).fiyat(BigDecimal.valueOf(40)).adet(10).toplamFiyat(BigDecimal.valueOf(400)).satisid(1L).build();
//      session.save(satisDetaUn);

//      builder ile musteri ekleme
//      Musteri musteri = Musteri.builder().ad("Fatih").build();

//      guncelleme
//      Musteri musteriAranan = session.get(Musteri.class,2L);
//      musteriAranan.setAd("Tarkan");
//      session.update(musteriAranan);

//      silme
//      Musteri musteriSilinecek = session.get(Musteri.class,3L);
//      session.delete(musteriSilinecek);

        CriteriaOrnekleri criteriaOrnekleri = new CriteriaOrnekleri();
        //criteriaOrnekleri.findAll().forEach(System.out::println);
        //criteriaOrnekleri.selectOneColumn().forEach(System.out::println);
        //String donenAd = criteriaOrnekleri.selectOneColumnById(2L);
        //System.out.println(donenAd);
        //Urun donenUrun = criteriaOrnekleri.findById(2L);
        //System.out.println(donenUrun);
//        criteriaOrnekleri.selectManyColumn().forEach(o->{
//            System.out.println("id: "+o[0]+" "+"ad: "+o[1]+" "+"fiyat: "+(  ((BigDecimal)o[2]).multiply(BigDecimal.valueOf(1.18))         )        );
//        });
        //criteriaOrnekleri.findAllByNameAndFiyatGt("%r%", BigDecimal.valueOf(1000)).forEach(System.out::println);
        //Urun urunLaptop = Urun.builder().ad("Laptop").fiyat(BigDecimal.valueOf(50000)).build();
        //new UrunRepository().save(urunLaptop);

        //new UrunRepository().deleteById(4L);
        //criteriaOrnekleri.findAllNativeQuery2().forEach(System.out::println);
        //criteriaOrnekleri.findAllNamedQuery().forEach(System.out::println);
        criteriaOrnekleri.findAllByNameNamedQuery("%r%").forEach(System.out::println);
    }
}