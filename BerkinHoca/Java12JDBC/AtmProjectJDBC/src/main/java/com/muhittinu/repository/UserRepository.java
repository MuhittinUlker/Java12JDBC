package com.muhittinu.repository;

import com.muhittinu.entity.User;
import com.muhittinu.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public User login(String email,String password){
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .email(resultSet.getString(3))
                        .build();
            }else {
                throw  new RuntimeException("Kullanici bulunamadi");
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
