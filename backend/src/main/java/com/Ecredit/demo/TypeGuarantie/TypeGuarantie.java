package com.Ecredit.demo.TypeGuarantie;

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
public class TypeGuarantie {
    @Id
    @SequenceGenerator(
            name = "TypeGuarantie_sequence",
            sequenceName = "TypeGuarantie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TypeGuarantie_sequence"
    )
    private long id ;
    private String nom;

}
