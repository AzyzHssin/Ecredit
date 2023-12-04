package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import com.Ecredit.demo.DemandeCredit.DemandeCredit;
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
    private long id;
    private int solde;
    private Date createDate;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<DemandeCredit> lisOfDemandeCredit;


}
