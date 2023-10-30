package com.muhittinu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
    private Connection connection;
    private static DbConnection instance;
    private DbConnection(){
        createConnection();
    }
    private void createConnection() {
        try {
            connection = DriverManager.getConnection(Constant.URL,Constant.USERNAME,Constant.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        try {
            if (connection.isClosed()){
            createConnection();}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static DbConnection getInstance(){
        if (instance==null){
            instance = new DbConnection();
        }
        return instance;
    }
}
