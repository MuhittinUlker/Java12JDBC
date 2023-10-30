package org.muhittinu.repository;

import org.muhittinu.repository.entitiy.Adres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresRepository implements  ICrud<Adres>{

    ConnectionProvider connectionProvider;

    public AdresRepository() {
        connectionProvider= new ConnectionProvider();
    }

    @Override
    public void save(Adres adres) {
        String query="INSERT INTO tbladres(musteriid, il, ilce, mahalle, adres) VALUES" +
                "("+adres.getMusteriid()+", '"+adres.getIl()+"', '"
                +adres.getIlce()+"', '"+adres.getMahalle()+"', '"+adres.getAdres()+"');";
        if (connectionProvider.myExecuteUpdate(query)){
            System.out.println("Adres kayit basarili");
        }else {
            System.out.println("Adres kayit basarisiz");
        }
    }

    @Override
    public void update(Adres adres) {
        String query = "UPDATE tbladres SET il='"+adres.getIl()+"', ilce='"+adres.getIlce()
                +"', mahalle='"+adres.getMahalle()+"', adres='"+adres.getAdres()+"' WHERE musteriid="+adres.getMusteriid()+";";
        if (connectionProvider.myExecuteUpdate(query)){
            System.out.println("Adres guncelleme basarili");
        }else {
            System.out.println("Adres guncellenirken hata meydana geldi");
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM tbladres WHERE id="+id;
        if (connectionProvider.myExecuteUpdate(query)){
            System.out.println("Adres silme basarili");
        }else {
            System.out.println("Adres silme sirasinda hata");
        }

    }

    @Override
    public List<Adres> findAll() {
        String query = "SELECT * FROM tbladres";
        Optional<ResultSet> optionalResultSet = connectionProvider.getAllData(query);
        if (optionalResultSet.isEmpty()) {
            return new ArrayList<>();
        }
        List<Adres> adresList = new ArrayList<>();
        try {
            while(optionalResultSet.get().next()){
                int id = optionalResultSet.get().getInt("id");
                int musteriid = optionalResultSet.get().getInt("musteriid");
                String il = optionalResultSet.get().getString("il");
                String ilce = optionalResultSet.get().getString("ilce");
                String mahalle = optionalResultSet.get().getString("mahalle");
                String adres = optionalResultSet.get().getString("adres");

                adresList.add(new Adres(id,musteriid,il,ilce,mahalle,adres));
            }
            return adresList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Adres findById(int idargs) {
        String query = "SELECT * FROM tbladres WHERE id="+idargs+";";
        Optional<ResultSet> resultSet = connectionProvider.getAllData(query);
        if (resultSet.isEmpty()){
            return new Adres();
        }
        try {
            resultSet.get().next();
            int id = resultSet.get().getInt(1);
            int musteriid = resultSet.get().getInt(2);
            String il = resultSet.get().getString(3);
            String ilce = resultSet.get().getString(4);
            String mahalle = resultSet.get().getString(5);
            String adres = resultSet.get().getString(6);
            return new Adres(id,musteriid,il,ilce,mahalle,adres);
        } catch (SQLException e) {
            System.out.println("Bu id ile kayitli bir adres bulunamadi");
        }
        return new Adres();
    }
}
