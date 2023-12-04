package com.Ecredit.demo.Devise;

import com.Ecredit.demo.Guarantie.Guarantie;
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
    @PostMapping("/add")
    public Devise createDevise(@RequestBody Devise devise) {
        System.out.println("Devise is created successefully");
        return deviseService.createDevise(devise);
    }
    @DeleteMapping("/{id}")
    public void deleteGuarantie(@PathVariable long id){
        deviseService.deleteDevise(id);
    }
}
