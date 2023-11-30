package SituationFamiliale;


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
private final SituationFamiliale.SituationFamilialeRepo situationFamilialeRepo;

    public List<SituationFamiliale.SituationFamiliale> getAllSituationFamiliale() {
        return situationFamilialeRepo.findAll();
    }

    public Optional<SituationFamiliale.SituationFamiliale> getSituationFamById(SingularAttribute<AbstractPersistable, Serializable> id){
        return situationFamilialeRepo.findById(id);
    }
}
