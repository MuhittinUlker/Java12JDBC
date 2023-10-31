package com.muhittinu.entity;

import com.muhittinu.util.RandomGenerateAccountNo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private int id;
    private int userid;
    private double balance;
    private String accountNo;
    private Date transactionDate;

}
