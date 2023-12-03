package com.Ecredit.demo.SituationFamiliale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SituationFamiliale {
    @Id
    private long id;
    private String situation;


}
