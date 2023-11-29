package com.Ecredit.demo.Guarantie;

import com.Ecredit.demo.Devise.Devise;
import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import com.Ecredit.demo.TypeGuarantie.TypeGuarantie;
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
public class Guarantie {
    @Id
    private long id;
    private long idDemande;
    private int valeur ;
    @OneToOne
    private NatureGuarantie natureGuarantie;
    @OneToOne
    private Devise devise;
    @OneToOne
    private TypeGuarantie typeGuarantie;




}