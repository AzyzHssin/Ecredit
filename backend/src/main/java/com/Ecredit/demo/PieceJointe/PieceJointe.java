package com.Ecredit.demo.PieceJointe;

import com.Ecredit.demo.TypeCredit.TypeCredit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PieceJointe {
@Id
@SequenceGenerator(
        name = "PieceJointe_sequence",
        sequenceName = "PieceJointe_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "PieceJointe_sequence"
)
private long id ;
private String nom;
private String obligatoire ;

@ManyToOne
private TypeCredit typeCredit;


}

