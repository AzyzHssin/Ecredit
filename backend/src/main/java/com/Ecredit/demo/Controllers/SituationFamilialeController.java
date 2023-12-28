package com.Ecredit.demo.SituationFamiliale;

import com.Ecredit.demo.Models.SituationFamiliale;
import com.Ecredit.demo.Service.SituationFamilialeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
