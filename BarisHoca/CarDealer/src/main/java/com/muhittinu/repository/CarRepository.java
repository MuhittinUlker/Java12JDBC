package com.muhittinu.repository;

import com.muhittinu.entitiy.Car;
import com.muhittinu.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICrud<Car>{
    @Override
    public void saveAll(List<Car> t) {
        if (databaseControl()){
            System.out.println("Zaten database'e verileri aktardiniz");
        }else {
            String query = "INSERT INTO cars(brand,car_model,model_year,dealer_id) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
                for (Car car : t) {
                    preparedStatement.setString(1, car.getBrand());
                    preparedStatement.setString(2, car.getCarModel());
                    preparedStatement.setString(3, car.getModelYear());
                    preparedStatement.setInt(4, car.getDealershipId());
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
    @Override
    public void save(Car car) {
        String query = "INSERT INTO cars(brand,car_model,model_year,dealer_id) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setString(3, car.getModelYear());
            preparedStatement.setInt(4, car.getDealershipId());
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
    public void update(Car car, int id) {
        String query = "UPDATE cars SET brand=?, car_model=?, model_year=? ,dealer_id=? WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setString(3, car.getModelYear());
            preparedStatement.setInt(4, car.getDealershipId());
            preparedStatement.setInt(5,id);
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
    public List<Car> findAll() {
        String sql = "SELECT * FROM cars";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        List<Car> carList = new ArrayList<>();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt(1));
                car.setBrand(resultSet.getString(2));
                car.setCarModel(resultSet.getString(3));
                car.setModelYear(resultSet.getString(4));
                car.setDealershipId(resultSet.getInt(5));
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }
    private boolean databaseControl(){
        String sql = "SELECT * FROM cars";
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
}
