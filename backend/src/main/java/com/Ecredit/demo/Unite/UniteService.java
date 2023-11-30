package com.Ecredit.demo.Unite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniteService {
    private final UniteRepo uniteRepo;

    public List<Unite.Unite> getAllUnite(){
        return uniteRepo.findAll();
    }
    public Optional <Unite.Unite> getUniteById(long id ){
        return uniteRepo.findById(id);
    }
}
