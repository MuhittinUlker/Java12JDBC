package org.muhittinu.repository;

import org.muhittinu.repository.entitiy.Musteri;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusteriRepository implements  ICrud<Musteri>{

    ConnectionProvider connectionProvider;

    public MusteriRepository() {
        this.connectionProvider=new ConnectionProvider();
    }

    @Override
    public void save(Musteri musteri) {
        String query="INSERT INTO tblmusteri(" +
                "ad, soyad, telefon, cinsiyet, dtarih) " +
                "VALUES ('"+musteri.getAd()+"', '"+musteri.getSoyad()+"', '"
                +musteri.getTelefon()+"', '"+musteri.getCinsiyet()+"', "
                +musteri.getDtarih()+");";
        connectionProvider.myExecuteUpdate(query);
    }

    @Override
    public void update(Musteri musteri) {
        String query="UPDATE tblmusteri" +
                " SET ad='"+musteri.getAd()+"', soyad='"+musteri.getSoyad()+
                "', telefon='"+musteri.getTelefon()+"', cinsiyet='"+musteri.getCinsiyet()+"', dtarih="+musteri.getDtarih()+
                " WHERE id="+musteri.getId();
        connectionProvider.myExecuteUpdate(query);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM tblmusteri WHERE id="+id;
        connectionProvider.myExecuteUpdate(query);
    }

    @Override
    public List<Musteri> findAll() {
        String query = "SELECT * FROM tblmusteri";
        Optional<ResultSet> optionalResultSet = connectionProvider.getAllData(query);
        if (optionalResultSet.isEmpty()) {
            return new ArrayList<>();
        }
        List<Musteri> musteriList = new ArrayList<>();
        try {
            while(optionalResultSet.get().next()){
                int id = optionalResultSet.get().getInt("id");
                String ad = optionalResultSet.get().getString("ad");
                String soyad = optionalResultSet.get().getString("soyad");
                String telefon = optionalResultSet.get().getString("telefon");
                String cinsiyet = optionalResultSet.get().getString("cinsiyet");
                long dtarih = optionalResultSet.get().getLong("dtarih");
                musteriList.add(new Musteri(id,ad,soyad,telefon,cinsiyet,dtarih));
            }
            return musteriList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Musteri findById(int idargs) {
        String query = "SELECT * FROM tblmusteri WHERE id="+idargs;
        Optional<ResultSet> optionalResultSet = connectionProvider.getAllData(query);
        if (optionalResultSet.isEmpty()) {
            return new Musteri();
        }
        try {   optionalResultSet.get().next();
                int id = optionalResultSet.get().getInt("id");
                String ad = optionalResultSet.get().getString("ad");
                String soyad = optionalResultSet.get().getString("soyad");
                String telefon = optionalResultSet.get().getString("telefon");
                String cinsiyet = optionalResultSet.get().getString("cinsiyet");
                long dtarih = optionalResultSet.get().getLong("dtarih");
                return new Musteri(id,ad,soyad,telefon,cinsiyet,dtarih);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Musteri();
    }
}
