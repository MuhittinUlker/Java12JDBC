package com.muhittinu.repository;

import com.muhittinu.entity.Account;
import com.muhittinu.entity.TransferDekont;
import com.muhittinu.entity.User;
import com.muhittinu.util.DbConnection;
import com.muhittinu.util.RandomGenerateAccountNo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public String createAccount(User user){
        String query = "INSERT INTO accounts(user_id,account_no) VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        Account account = Account.builder()
                .userid(user.getId())
                .accountNo(RandomGenerateAccountNo.generateAccountNo())
                .build();
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,account.getUserid());
            preparedStatement.setString(2, account.getAccountNo());
            if (preparedStatement.executeUpdate()>0){
                return  account.getAccountNo();
            }else {
                throw new RuntimeException("Hesap olusturma isleminde hata");
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
    public List<Account> getAccountsByEmail(String email){
        String query ="SELECT accounts.* FROM users INNER JOIN accounts ON users.id = accounts.user_id WHERE users.email=?";
        PreparedStatement preparedStatement=null;
        List<Account> accountList;
        try {
            preparedStatement=DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            accountList = new ArrayList<>();
            Account account;

            while(resultSet.next()){
                double balance = resultSet.getDouble(3);
                String accountNo = resultSet.getString(4);
                int id = resultSet.getInt(1);
                Date creationDate = resultSet.getDate(5);
                int anInt = resultSet.getInt(2);
                account=Account.builder()
                        .accountNo(accountNo)
                        .transactionDate(creationDate)
                        .id(id)
                        .balance(balance)
                        .userid(anInt)
                        .build();
                accountList.add(account);
            }
            return accountList;
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

    public TransferDekont transferMoney(int amount, String accountNo,User user){
        String query = "UPDATE accounts SET balance = balance+? where account_no=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setString(2,accountNo);
            preparedStatement.executeUpdate();
            String receiverName = findUserNameByAcountNo(accountNo);
            TransferDekont transferDekont = TransferDekont.builder()
                    .transactionDate(new java.util.Date())
                    .sendAmountTotal(amount)
                    .senderName(user.getName())
                    .receiverName(receiverName)
                    .build();
            return transferDekont;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String findUserNameByAcountNo(String accountNo){
        String query = "SELECT users.name FROM users INNER JOIN accounts on users.id = accounts.user_id WHERE account_no=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString(1);}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
