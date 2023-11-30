package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.TypeCredit.TypeCredit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PieceJointe {
@Id
private long id ;
private String nom;
private String type ;
@ManyToOne
private TypeCredit typeCredit;


}

