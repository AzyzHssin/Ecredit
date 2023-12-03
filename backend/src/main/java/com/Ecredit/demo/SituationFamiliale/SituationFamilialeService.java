package com.Ecredit.demo.SituationFamiliale;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SituationFamilialeService {
private final SituationFamilialeRepo situationFamilialeRepo;

    public List<SituationFamiliale> getAllSituationFamiliale() {
        return situationFamilialeRepo.findAll();
    }

    public Optional<SituationFamiliale> getSituationFamById(long id){
        return situationFamilialeRepo.findById(id);
    }
}
