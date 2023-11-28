package com.Ecredit.demo.Customer;

import com.Ecredit.demo.BankAccount.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    private long cin;
    private String lastName;
    private String firstName;
    private Date birthday;
    @Transient
    private List<BankAccount> listOfAccounts;
}
