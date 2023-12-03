package com.Ecredit.demo.SituationFamiliale;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
