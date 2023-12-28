package com.Ecredit.demo.Unite;

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
public class Unite {
    @Id
    @SequenceGenerator(
            name = "Unite_sequence",
            sequenceName = "Unite_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Unite_sequence"
    )
    private long id ;
    private String nom;
}
