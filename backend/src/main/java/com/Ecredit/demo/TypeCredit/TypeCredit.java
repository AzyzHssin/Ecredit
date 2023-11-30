package com.Ecredit.demo.TypeCredit;

import com.Ecredit.demo.PieceJointe.PieceJointe;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class TypeCredit {
    @Id
    private Long id;
    private String nom;
    @OneToMany
    private List<PieceJointe> piecesJointes;




}
