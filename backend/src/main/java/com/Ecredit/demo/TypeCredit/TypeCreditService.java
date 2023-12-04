package com.Ecredit.demo.TypeCredit;

import com.Ecredit.demo.SituationFamiliale.SituationFamiliale;
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

    public TypeCredit createTypeCredit(TypeCredit typeCredit) {
        return typeCreditRepo.save(typeCredit);
    }
    public void deleteTypeCredit(Long id) {
        typeCreditRepo.deleteById(id);
    }
}
