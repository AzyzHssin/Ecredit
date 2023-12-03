package com.Ecredit.demo.TypeCredit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/TypeCredit")
public class TypeCreditController {
    private final TypeCreditService typeCreditService;
    @GetMapping
    public List<TypeCredit> getAllTypeCredit(){
       return  typeCreditService.getAllTypeCredit();
    }
    @GetMapping("/{id}")
    public Optional<TypeCredit> getTypeCreditById(@PathVariable long id ){
       return  typeCreditService.getTypeCreditById(id );
    }
}
