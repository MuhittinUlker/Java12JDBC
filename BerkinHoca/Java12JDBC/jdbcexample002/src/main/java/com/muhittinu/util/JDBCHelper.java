package com.muhittinu.util;

import com.muhittinu.util.constant.JDBCConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCHelper {

    public static Optional<Connection> getConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(JDBCConstant.URL,JDBCConstant.USERNAME,JDBCConstant.PASSWORD);
            System.out.println("Baglanti Basarili");
            return Optional.of(connection);
        } catch (SQLException e) {
            System.out.println("Baglanti Basarisiz");
            return Optional.empty();
        }
    }


}
