package org.muhittinu;

import java.sql.*;

/*
VERITABANI DRIVER:
Bir programlama dili ile veritabani arasinda iletisim kurmak icin kullanilan bilesendir.
Yapilabilecekler:
    VT sunucusuna baglanacagiz
    VT ile iletisim kuracagiz
    Sorgular gonderecegiz
    Sonuclari alma bu tur temel islemleri yapmakta yardimci olur.
Driverlari vt ureticisi uretir.

PostgreSQL JDBC Driver
Oracle JDBC Driver
MSSQL JDBC Driver

-- Dependencies: Disaridan projeye dahil ettigimiz kutuphanelere olan bagimliliktir
-- ANT-MAVEN-GRADLE

 */
public class Main {
    public static void main(String[] args) {
        //JDBC kullaniminda ilk yapilacak islem 2 sistem arasinda iletisimi saglayacak DRIVER'i devreye almaktir.
        //Java 1.6dan once kullanilmasi gereken yapi
        //Driver.class.forName("org.postgresql.Driver");

        //Driver ile sunucuya baglanmak icin gerekli parametreler:
        //1-VT server'inin IP adresi (host)
        //2-Port numarasi
        //3-Islem yapilacak DB adi

        //4-Yetkilendirme icin username
        //5-Yekilendirme icin password
        //jdbc:postgresql://host:port/database
        // host: VT tutan yapi. Eger uzak sunucudaysa ip girilir
        // local ise localhost ya da 127.0.0.1 yazilabilir


        //DriverManager araciligi ile bir Connection nesnesi olusturulur.
        //Connection referansi olusturabilmek icin url,,username,password bilgilerini
        //getConnection metoduna verdik.

        //Bu yazdigimiz sql driver tarafindan anlasilamaz
        //Drive'in anlayabilecegi yapiya getirmek icin prepareStatement kullanilir

        // adresEklePrepared(80, "Istanbul", "Bakirkoy", "Yesilkoy", "Cinar Sk. No:3");

       // adresSil(5);

       // adreseGuncelle(6,"Mugla","Fethiye");

        adresIleGoreListele("a");
    }

    public static void adresEkle(int musteriid, String il, String ilce, String mahalle, String adres) throws Exception {
        String connectionAddress = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        Connection connection = DriverManager.getConnection(connectionAddress, username, password);
        String adresEkleSql = "INSERT INTO public.tbladres(" +
                "musteriid, il, ilce, mahalle, adres)" +
                "VALUES (" + musteriid + ",'" + il + "','" + ilce + "','" + mahalle + "','" + adres + "');";
        // "VALUES ("+musteriid+",'"+il+"','"+ilce+"','"+mahalle+"','"+adres+"');";
        PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public static void adresEklePrepared(int musteriid, String il, String ilce, String mahalle, String adres) {
        //Baglanti ile ilgili kodlarimiz:
        String connectionAddress = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        String adresEkleSql = "INSERT INTO public.tbladres(musteriid, il, ilce, mahalle, adres) VALUES(?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(connectionAddress, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql)) {
            //Sorgumuz:
            preparedStatement.setInt(1, musteriid);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
            preparedStatement.setString(4, mahalle);
            preparedStatement.setString(5, adres);
            //Sorgu calistirma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Ekleme basari ile gerceklesti");
            else System.out.println("Eklemede hata meydana geldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresSil(int id){
        String connectionAddress = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        String adresSilSql = "DELETE FROM tbladres WHERE id=?";
        try (Connection connection = DriverManager.getConnection(connectionAddress, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresSilSql)) {
            //Sorgumuz:
            preparedStatement.setInt(1, id);
            //Sorgu calistirma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Silme basari ile gerceklesti");
            else System.out.println("Silmede hata meydana geldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adreseGuncelle(int id, String il, String ilce){
        String connectionAddress = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        String adresGuncelleSql = "UPDATE tbladres SET il=?, ilce=? WHERE id=?";
        try (Connection connection = DriverManager.getConnection(connectionAddress, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresGuncelleSql)) {
            //Sorgumuz:
            preparedStatement.setString(1, il);
            preparedStatement.setString(2, ilce);
            preparedStatement.setInt(3, id);
            //Sorgu calistirma:
            int etkilenenSatirSayisi = preparedStatement.executeUpdate();
            if (etkilenenSatirSayisi > 0) System.out.println("Guncelleme basari ile gerceklesti");
            else System.out.println("Guncellemede hata meydana geldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void adresIleGoreListele(String ilargs){
        String connectionAddress = "jdbc:postgresql://localhost:5432/Java12SatisVT";
        String username = "postgres";
        String password = "1234";
        String adresListeleSql = "SELECT * FROM tbladres WHERE il ILIKE ? ORDER BY musteriid";
        try (Connection connection = DriverManager.getConnection(connectionAddress, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(adresListeleSql)) {
            //Sorgumuz:
            preparedStatement.setString(1, "%"+ilargs+"%");
            //Sorgu calistirma:
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int musteriid = resultSet.getInt("musteriid");
                String il = resultSet.getString("il");
                String ilce = resultSet.getString("ilce");
                System.out.println("Musteri ID: "+musteriid+" Il: "+il+" Ilce: "+ilce);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


/*
                                executeQuery()      executeUpdate()                     execute()
        Geriye donen deger:     ResultSet(Tablo)    Int(Etkilenen Satir Sayisi)
        Nerede Kullanilir:      SELECT Sorgularda   INSERT,DELETE,UPDATE sorgulari      Tum Sorgular

        execute()
        Eger SQL INSERT UPDATE DELETE geciyorsa geriye int doner
        Eger SQL SELECT geciyorsa geriye resultSet doner
        Eger SQL ALTER,CREATE,DROP geciyorsa geriye true/false doner
 */