package com.Ecredit.demo.TypeGuarantie;

import com.Ecredit.demo.TypeCredit.TypeCredit;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeGuarantieService {
    private final TypeGuarantieRepo typeGuarantieRepo;

    public List<TypeGuarantie> getAllTypeGuarantie(){
        return typeGuarantieRepo.findAll();
    }
    public Optional<TypeGuarantie> getTypeGuarantieById(long id){
        return typeGuarantieRepo.findById(id);
    }

    public TypeGuarantie createTypeGuarantie(TypeGuarantie typeGuarantie) {
        return typeGuarantieRepo.save(typeGuarantie);
    }

    public void deleteTypeGuarantie(Long id) {
        typeGuarantieRepo.deleteById(id);
    }

}
