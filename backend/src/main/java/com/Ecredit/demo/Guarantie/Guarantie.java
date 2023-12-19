package com.Ecredit.demo.Guarantie;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.Ecredit.demo.Devise.Devise;
import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import com.Ecredit.demo.TypeGuarantie.TypeGuarantie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guarantie {
    @Id
    @SequenceGenerator(
            name = "Guarantie_sequence",
            sequenceName = "Guarantie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Guarantie_sequence"
    )
    private long id;
//    private long idDemande;
    private int valeur ;
    @OneToOne
    private NatureGuarantie natureGuarantie;
    @OneToOne
    private Devise devise;
    @OneToOne
    private TypeGuarantie typeGuarantie;
    @OneToMany
    private List<DemandeCredit> demandeCredits;




}
