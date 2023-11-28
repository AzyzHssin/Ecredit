package com.Ecredit.demo.Guarantie;

import com.Ecredit.demo.Devise.Devise;
import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import com.Ecredit.demo.TypeGuarantie.TypeGuarantie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
    @ManyToOne
    private NatureGuarantie natureGuarantie;
    private Devise devise;
    private TypeGuarantie typeGuarantie;




}
