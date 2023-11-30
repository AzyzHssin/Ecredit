package com.Ecredit.demo.TypeCredit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeCreditService {
    private final TypeCreditRepo typeCreditRepo;
    public List<TypeCredit> getAllTypeCredit(){
        return typeCreditRepo.findAll();
    }
    public Optional<TypeCredit> getTypeCreditById(long id){
        return typeCreditRepo.findById(id);
    }
}
