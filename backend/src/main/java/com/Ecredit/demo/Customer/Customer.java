package com.Ecredit.demo.Customer;

import com.Ecredit.demo.BankAccount.BankAccount;

import com.Ecredit.demo.SituationFamiliale.SituationFamiliale;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToMany
    @JsonIgnoreProperties({"customer"})
    private List<BankAccount> listOfAccounts;
    @OneToOne
    private SituationFamiliale situationFamiliale;
}
