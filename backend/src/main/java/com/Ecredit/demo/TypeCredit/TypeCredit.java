package com.Ecredit.demo.TypeCredit;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.Ecredit.demo.PieceJointe.PieceJointe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypeCredit {
    @Id
    @SequenceGenerator(
            name = "TypeCredit_sequence",
            sequenceName = "TypeCredit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TypeCredit_sequence"
    )
    private long id;
    private String nom;
    @OneToMany
    @JsonIgnoreProperties("typeCredit")
    private List<PieceJointe> piecesJointes;

}
