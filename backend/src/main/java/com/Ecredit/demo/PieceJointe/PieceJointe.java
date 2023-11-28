package com.Ecredit.demo.PieceJointe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PieceJointe {
@Id
    private long id ;
private String nom;
private String type ;
private long idTypeCredit;


}

