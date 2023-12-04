package com.Ecredit.demo.SituationFamiliale;

import com.Ecredit.demo.TypeCredit.TypeCredit;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/SituationFamiliale")


public class SituationFamilialeController {
    private final SituationFamilialeService situationFamilialeService;

    @GetMapping
    public List<SituationFamiliale> getAllSituationFamiliale(){
        return situationFamilialeService.getAllSituationFamiliale();
    }
    @GetMapping("/{id}")
   public Optional<SituationFamiliale> getSituationFamilialeById(@PathVariable long id){
        return situationFamilialeService.getSituationFamById(id);
    }
    @PostMapping("/add")
    public SituationFamiliale createSituationFamiliale(@RequestBody SituationFamiliale situationFamiliale) {
        System.out.println("SituationFamiliale is created successefully");
        return situationFamilialeService.createSituationFamiliale(situationFamiliale);
    }
    @DeleteMapping("/{id}")
    public void deleteSituationFamiliale(@PathVariable long id){
        situationFamilialeService.deleteSituationFamiliale(id);
    }

}
