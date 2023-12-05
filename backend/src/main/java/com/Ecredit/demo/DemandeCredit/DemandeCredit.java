package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.Unite.Unite;
import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.Guarantie.Guarantie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

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
    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;
    @OneToOne
    private Unite unite;
    @JsonIgnore
    @OneToMany
    private List<Guarantie> guaranties;

}
