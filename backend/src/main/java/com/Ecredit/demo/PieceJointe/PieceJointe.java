package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.TypeCredit.TypeCredit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PieceJointe {
@Id
private long id ;
private String nom;
private String type ;
@ManyToOne
private TypeCredit typeCredit;


}

