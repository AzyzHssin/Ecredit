package com.Ecredit.demo.Customer;

import com.Ecredit.demo.BankAccount.BankAccount;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table
public class Customer {
    @Id
    private long cin;
    private String lastName;
    private String firstName;
    private Date birthday;
    private ArrayList<BankAccount> listOfAccounts;
}
