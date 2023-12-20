package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
        @SequenceGenerator(
            name = "BankAccount_sequence",
            sequenceName = "BankAccount_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BankAccount_sequence"
    )
    private long id;
    private int solde;
    private Date createDate;
    @ManyToOne
    private Customer customer;
    @OneToMany
    @JsonIgnore
    private List<DemandeCredit> demandeCredits;

}
