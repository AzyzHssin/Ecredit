package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.Unite.Unite;
import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.Guarantie.Guarantie;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class DemandeCredit{
    @Id
    @SequenceGenerator(
            name = "credit_sequence",
            sequenceName = "credit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_sequence"
    )
    private long id;
    private int montant;
    private int nbreEcheance;
    private String Observation;
    @OneToOne
    private BankAccount bankAccount;
    @OneToOne
    private Unite unite;

    @OneToMany
    private List<Guarantie> guarantie;

}
