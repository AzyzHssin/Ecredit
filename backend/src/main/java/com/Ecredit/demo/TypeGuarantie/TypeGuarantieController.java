package com.Ecredit.demo.TypeGuarantie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public TypeGuarantie createTypeGuarantie(@RequestBody TypeGuarantie typeGuarantie) {
        System.out.println("TypeGuarantie is created successefully");
        return typeGuarantieService.createTypeGuarantie(typeGuarantie);
    }
    @DeleteMapping("/{id}")
    public void deleteTypeGuarantie(@PathVariable long id){
        typeGuarantieService.deleteTypeGuarantie(id);
    }

}
