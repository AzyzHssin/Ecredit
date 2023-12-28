package com.Ecredit.demo.SituationFamiliale;

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
public class SituationFamiliale {
    @Id
    @SequenceGenerator(
            name = "SituationFamiliale_sequence",
            sequenceName = "SituationFamiliale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SituationFamiliale_sequence"
    )
    private long id;
    private String situation;


}
