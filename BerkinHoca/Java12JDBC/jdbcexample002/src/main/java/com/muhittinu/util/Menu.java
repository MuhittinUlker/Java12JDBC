package com.muhittinu.util;

import com.muhittinu.controller.PersonController;
import com.muhittinu.entitiy.Person;
import com.muhittinu.repository.PersonRepository;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final PersonController personController;
    public Menu(){
        personController=new PersonController();
    }
    public void Menu(){

        while (true){
            System.out.println("--> DataBase Islemleri <--");
            System.out.println("1 --> Data base veri ekle");
            System.out.println("2 --> Data base tum verileri goruntuleme.");
            System.out.println("3 --> Data base tum verileri silme.");
            System.out.println("4 --> Data base mail guncelleme.");
            System.out.println("5 --> Data base id ile veri arama");
            System.out.println("6 --> Data base id ile veri silme.");
            System.out.println("0 --> Cikis");
            System.out.print("Seciminizi girin: ");
            int secim = scanner.nextInt();scanner.nextLine();
            int idargs;
            String tableName;
            switch (secim) {
                case 1:
                    System.out.print("isim: ");
                    String name = scanner.nextLine();
                    System.out.print("Soyisim: ");
                    String surname = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Person person = new Person(name,surname,email);
                    personController.register(person);
                    break;
                case 2:
                    personController.getAll();
                    break;
                case 3:
                    System.out.print("Silmek istediginiz tablo adini girin: ");
                    tableName = scanner.nextLine();
                    personController.clearAll(tableName);
                    break;
                case 4:
                    System.out.print("Eski mailinizi girin: ");
                    String oldMail = scanner.nextLine();
                    System.out.print("Yeni mailinizi girin: ");
                    String newMail = scanner.nextLine();
                    personController.update(oldMail,newMail);
                    break;
                case 5:
                    System.out.print("Aranacak id'yi girin: ");
                    idargs = scanner.nextInt();scanner.nextLine();
                    personController.findById(idargs);
                    break;
                case 6:
                    System.out.print("Veri silmek istediginiz tablo adini girin: ");
                    tableName = scanner.nextLine();
                    System.out.print("Silinecek id'yi girin: ");
                    idargs = scanner.nextInt();scanner.nextLine();
                    personController.deleteById(tableName,idargs);
                    break;
                case 0:
                    System.out.println("Cikis yapildi..");
                    System.exit(0);
                    break;
            }
        }
    }
}
