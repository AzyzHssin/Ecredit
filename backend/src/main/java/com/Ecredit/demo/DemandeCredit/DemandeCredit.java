package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.ScannedDocument.ScannedDocument;
import com.Ecredit.demo.TypeCredit.TypeCredit;
import com.Ecredit.demo.Unite.Unite;
import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.Guarantie.Guarantie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.Ecredit.demo.File.DocumentFile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @OneToOne
    /*@JoinColumn(name = "type_credit_id")*/
    private TypeCredit typeCredit;
   /* @ManyToOne
    @JoinColumn(name = "customer_cin")
    Customer customer;*/
    @OneToMany
    @JsonIgnoreProperties({"demandeCredit"})
    private List<Guarantie> guaranties;

    @OneToMany
    @JsonIgnore
    private List<DocumentFile> documentFiles;

    @ManyToOne
    @JoinColumn(name = "scanned_document_id")
    @JsonIgnoreProperties({"demandeCredit"})
    private ScannedDocument scannedDocument;
    //abath id fil payload

}
