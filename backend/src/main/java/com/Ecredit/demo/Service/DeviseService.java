package com.Ecredit.demo.Devise;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviseService {

    private final DeviseRepo deviseRepo;
    public List<Devise> getAllDevise(){
        return deviseRepo.findAll();
    }
    public Optional<Devise> getDeviseById(long id){
        return deviseRepo.findById(id);
    }
    public Devise createDevise(Devise devise) {
        return deviseRepo.save(devise);
    }
    public void deleteDevise(Long id) {
        deviseRepo.deleteById(id);
    }
}
