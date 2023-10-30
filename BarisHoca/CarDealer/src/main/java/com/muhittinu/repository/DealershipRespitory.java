package com.muhittinu.repository;

import com.muhittinu.entitiy.Car;
import com.muhittinu.entitiy.Dealership;
import com.muhittinu.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipRespitory implements ICrud<Dealership> {
    @Override
    public void saveAll(List<Dealership> t) {
        if (databaseControl()){
            System.out.println("Zaten database'e verileri aktardiniz");
        }else {
            String query = "INSERT INTO dealers(name,country,city) VALUES(?,?,?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
                for (Dealership dealership : t) {
                    preparedStatement.setString(1, dealership.getName());
                    preparedStatement.setString(2, dealership.getCountry());
                    preparedStatement.setString(3, dealership.getCity());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean databaseControl() {
        String sql = "SELECT * FROM dealers";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Dealership dealership) {
        String query = "INSERT INTO dealers(name,country,city) VALUES(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1, dealership.getName());
            preparedStatement.setString(2, dealership.getCountry());
            preparedStatement.setString(3, dealership.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void update(Dealership dealership, int id) {
        String query = "UPDATE dealers SET name=?, country=?, city=? WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1, dealership.getName());
            preparedStatement.setString(2, dealership.getCountry());
            preparedStatement.setString(3, dealership.getCity());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Dealership> findAll() {
        String sql = "SELECT * FROM dealers";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        List<Dealership> dealershipList = new ArrayList<>();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Dealership dealership = new Dealership();
                dealership.setId(resultSet.getInt(1));
                dealership.setName(resultSet.getString(2));
                dealership.setCountry(resultSet.getString(3));
                dealership.setCity(resultSet.getString(4));
                dealershipList.add(dealership);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dealershipList;
    }
    public void hangiTedarikciHangiArabayiSatiyor(){
        String sql = "SELECT COUNT(*) FROM dealers";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        int dealerCount;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            dealerCount = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        String query = "SELECT \"DEALER_NAME\",\"CAR_BRAND\",\"CAR_MODEL\" FROM vw_car_dealer_match WHERE \"DEALER_ID\"=?";
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet2 = null;
        List<String > carDealerMatchList = new ArrayList<>();
        carDealerMatchList.add("DealerName\t\t\tCarBrand\t\t\tCarModel");
        try {
            preparedStatement2=DbConnection.getInstance().getConnection().prepareStatement(query);
            int i;
            for (i=1;i<=dealerCount;i++){
                preparedStatement2.setInt(1,i);
                resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()){
                    carDealerMatchList.add(resultSet2.getString(1)+"\t\t"+resultSet2.getString(2)+"\t\t"+resultSet2.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement2.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        carDealerMatchList.forEach(System.out::println);
    }
}
