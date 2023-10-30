package org.muhittinu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MusteriEkleme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ad,soyad,telefon,cinsiyet;
        Long dtarih;
        System.out.println("**************************");
        System.out.println("******Musteri Ekleme******");
        System.out.println("**************************");
        System.out.println();
        System.out.print("Musteri adi: ");
        ad = scanner.nextLine();
        System.out.print("Musteri soyadi: ");
        soyad = scanner.nextLine();
        System.out.print("Musteri telefon: ");
        telefon = scanner.nextLine();
        System.out.print("Musteri cinsiyet: ");
        cinsiyet = scanner.nextLine();
        System.out.print("Musteri DogumTarihi: ");
        dtarih= scanner.nextLong();scanner.nextLine();

        save(ad,soyad,telefon,cinsiyet,dtarih);

    }
    public static void save(String ad,String soyad,String telefon,String cinsiyet,Long dtarihi) {
        String connectionString = "jdbc:postgresql://localhost:5432/Java12SatisVT?user=postgres&password=1234";
        String QUERY_MUSTERI_INSERT = "INSERT INTO tblmusteri(ad,soyad,telefon,cinsiyet,dtarih) VALUES(?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_MUSTERI_INSERT)) {
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, telefon);
            preparedStatement.setString(4, cinsiyet);
            preparedStatement.setLong(5, dtarihi);
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Ekleme basari ile gerceklesti");
            else System.out.println("Eklemede hata meydana geldi");
        } catch (SQLException e) {
            System.out.println("Save metodunda hata"+e);
        }
    }
}