package com.Ecredit.demo.DemandeCredit;

import Unite.Unite;
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
    @Transient
    private List<Unite> uniteList  ;

    private long idBankAccount;


}
