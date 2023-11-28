package com.Ecredit.demo.TypeCredit;

import com.Ecredit.demo.PieceJointe.PieceJointe;
import org.hibernate.mapping.Array;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table
public class TypeCredit {
    @Id
    private Long id;
    private String nom;
    private ArrayList<PieceJointe> pieces;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    public ArrayList<PieceJointe> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<PieceJointe> pieces) {
        this.pieces = pieces;
    }

    private long idUnite;

}
