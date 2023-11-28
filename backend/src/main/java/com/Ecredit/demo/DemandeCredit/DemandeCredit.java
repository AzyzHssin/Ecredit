package com.Ecredit.demo.DemandeCredit;

import Unite.Unite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
