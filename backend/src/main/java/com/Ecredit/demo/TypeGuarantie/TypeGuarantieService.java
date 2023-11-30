package com.Ecredit.demo.TypeGuarantie;

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
}
