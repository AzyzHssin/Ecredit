package com.Ecredit.demo.NatureGuarantie;

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

public class NatureGuarantie {
    @Id
    @SequenceGenerator(
            name = "NatureGuarantie_sequence",
            sequenceName = "NatureGuarantie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "NatureGuarantie_sequence"
    )
    private long id ;
    private String nom;


}
