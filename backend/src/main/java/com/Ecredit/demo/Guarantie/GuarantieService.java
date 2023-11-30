package com.Ecredit.demo.Guarantie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class GuarantieService {
    private final GuarantieRepo guarantieRepo;

    public List<Guarantie> getAllGuarantie (){
        return guarantieRepo.findAll();
    }

    public Optional<Guarantie> getGuarantieById(long id){
        return guarantieRepo.findById(id);
    }
}
