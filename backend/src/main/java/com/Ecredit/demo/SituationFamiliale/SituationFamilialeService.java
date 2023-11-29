package SituationFamiliale;


import java.util.Optional;

public class SituationFamilialeService {
private final SituationFamilialeRepo situationFamilialeRepo;

    public SituationFamilialeService(SituationFamilialeRepo situationFamilialeRepo) {
        this.situationFamilialeRepo = situationFamilialeRepo;
    }

    public Optional<SituationFamiliale> getSituationFamById(Long Id){
        return situationFamilialeRepo.findById(Id);
    }
}
