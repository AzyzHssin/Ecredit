package com.Ecredit.demo.Devise;

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
public class Devise {
    @Id
    @SequenceGenerator(
            name = "Devise_sequence",
            sequenceName = "Devise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Devise_sequence"
    )
    private long id ;
    private String nom;

}
