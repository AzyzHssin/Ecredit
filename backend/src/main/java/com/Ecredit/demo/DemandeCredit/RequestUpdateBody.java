package com.Ecredit.demo.DemandeCredit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateBody {
    private DemandeCredit demande;
    private String nouvelEtat;
}
