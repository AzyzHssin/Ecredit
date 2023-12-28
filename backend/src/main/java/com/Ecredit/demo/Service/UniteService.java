package com.Ecredit.demo.Unite;

import com.Ecredit.demo.TypeGuarantie.TypeGuarantie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniteService {
    private final UniteRepo uniteRepo;

    public List<Unite> getAllUnite(){
        return uniteRepo.findAll();
    }
    public Optional <Unite> getUniteById(long id ){
        return uniteRepo.findById(id);
    }
    public Unite createUnite(Unite unite) {
        return uniteRepo.save(unite);
    }
    public void deleteUnite(Long id) {
        uniteRepo.deleteById(id);
    }
}
