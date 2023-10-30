package com.muhittinu.repository;

import com.muhittinu.entitiy.Person;
import com.muhittinu.util.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
public class PersonRepository implements  ICrud<Person>{
    public void register(Person person){
        save(person);
        System.out.println("Kayit Basarili");
    }
    @Override
    public void save(Person person) {
        String query = "INSERT INTO persons(first_name,last_name,email) VALUES(?,?,?)";
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.get().prepareStatement(query);
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setString(3,person.geteMail());
            preparedStatement.executeUpdate();
            System.out.println("Kayit Basarili");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void getAll() {
        String query = "SELECT * FROM persons";
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        int id;
        String name,surname,email;
        Date date;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.get().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                id=resultSet.getInt(1);
                name=resultSet.getString(2);
                surname=resultSet.getString(3);
                date=resultSet.getDate(4);
                email=resultSet.getString(5);
                Person person = new Person(id,name,surname,date,email);
                System.out.println(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void clearAll(String tableName) {
        String query = "DELETE FROM "+tableName;
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=JDBCHelper.getConnection();
            preparedStatement=connection.get().prepareStatement(query);
            if (preparedStatement.executeUpdate()>0){
                System.out.println("Tum veriler silindi");
            }else {
                System.out.println("Silme islemi basarisiz");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void deleteById(String tableName,int idargs) {
        String query = "DELETE FROM "+tableName+" WHERE id=?";
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=JDBCHelper.getConnection();
            preparedStatement=connection.get().prepareStatement(query);
            preparedStatement.setInt(1,idargs);
            if (preparedStatement.executeUpdate()>0){
                System.out.println("Kayit silindi");
            }else {
                System.out.println("Girilen id'de bir kayit bulunamadi");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void findById(int idargs) {
        String query = "SELECT * FROM persons WHERE id=?";
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=JDBCHelper.getConnection();
            preparedStatement=connection.get().prepareStatement(query);
            preparedStatement.setInt(1,idargs);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()){
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            String surname=resultSet.getString(3);
            Date date=resultSet.getDate(4);
            String email=resultSet.getString(5);
            Person person = new Person(id,name,surname,date,email);
            System.out.println(person);
            } else {
                System.out.println("Girilen id'de bir kayit bulunamadi");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void update(String oldData,String newData) {
        String query = "UPDATE persons SET email=? WHERE email=?";
        Optional<Connection> connection=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.get().prepareStatement(query);
            preparedStatement.setString(1,newData);
            preparedStatement.setString(2,oldData);
            if (preparedStatement.executeUpdate()>0){
                System.out.println("Guncelleme basarili");
            }else {
                System.out.println("Girilen mail ile kayitli bir kullanici bulunamadi");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.get().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
