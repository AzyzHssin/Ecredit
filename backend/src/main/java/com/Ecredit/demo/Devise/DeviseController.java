package com.Ecredit.demo.Devise;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Devise")
public class DeviseController {

    private final DeviseService deviseService;
    @GetMapping
    public List<Devise> getAllDevise(){
        return deviseService.getAllDevise();
    }
    @GetMapping("/{id}")
    public Optional<Devise> getDeviseById(@PathVariable long id){
        return deviseService.getDeviseById(id);
    }
}
