package com.Ecredit.demo.NatureGuarantie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NatureGuarantieService {
    private final NatureGuarantieRepo natureGuarantieRepo;

    public List<NatureGuarantie> getAllNatureGuarantie (){
        return natureGuarantieRepo.findAll();
    }
    public Optional<NatureGuarantie> getNatureGuarantieById(long id){
        return natureGuarantieRepo.findById(id);
    }
}
