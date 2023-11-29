package com.Ecredit.demo.Devise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviseService {

    private final DeviseRepo deviseRepo;
    public List<Devise> getAllDevise(){
        return deviseRepo.findAll();
    }
    public Optional<Devise> getDeviseById(long id){
        return deviseRepo.findById(id);
    }
}
