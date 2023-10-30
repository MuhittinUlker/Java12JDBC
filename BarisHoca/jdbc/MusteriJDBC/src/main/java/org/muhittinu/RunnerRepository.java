package org.muhittinu;

import org.muhittinu.repository.AdresRepository;
import org.muhittinu.repository.MusteriRepository;

public class RunnerRepository {
    public static void main(String[] args) {
        MusteriRepository repository = new MusteriRepository();
        //repository.save(new Musteri("Arda","Guler","723456","Erkek",56123598023L));
        //repository.delete(1002);
        //repository.findAll().forEach(System.out::println);
        //System.out.println("Update oncesi");
        //System.out.println(repository.findById(1003));
        //Musteri musteri = repository.findById(1003);
        //musteri.setAd("Arda Jr.");
        //musteri.setSoyad("Guler Jr.");
        //musteri.setTelefon("12341231");
        //repository.update(musteri);
        //System.out.println("Update sonrasi");
        //System.out.println(repository.findById(1003));
        AdresRepository adresRepository = new AdresRepository();
        //Adres adres = new Adres(6,"Istanbul","Kadikoy","Moda","Kara Sk. No:22/8");
        //adresRepository.save(adres);
        //adresRepository.update(adres);
        //System.out.println(adresRepository.findById(6));
        //adresRepository.delete(53);
        //adresRepository.findAll().forEach(System.out::println);

    }
}
