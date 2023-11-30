package com.Ecredit.demo.TypeGuarantie;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/TypeGuarantie")

public class TypeGuarantieController {
    private final TypeGuarantieService typeGuarantieService;

    @GetMapping
    public List<TypeGuarantie> getAllTypeGarantie (){
        return typeGuarantieService.getAllTypeGuarantie();
    }
    @GetMapping("/{id}")
    public Optional<TypeGuarantie> getTypeGarantieById(@PathVariable long id){
        return typeGuarantieService.getTypeGuarantieById(id);
    }

}
