package com.Ecredit.demo.TypeCredit;

import com.Ecredit.demo.TypeGuarantie.TypeGuarantie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public TypeCredit createTypeCredit(@RequestBody TypeCredit typeCredit) {
        System.out.println("TypeCredit is created successefully");
        return typeCreditService.createTypeCredit(typeCredit);
    }
    @DeleteMapping("/{id}")
    public void deleteTypeCredit(@PathVariable long id){
        typeCreditService.deleteTypeCredit(id);
    }
}
