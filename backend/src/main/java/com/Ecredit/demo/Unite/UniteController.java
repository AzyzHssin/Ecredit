package com.Ecredit.demo.Unite;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/Unite")
public class UniteController {
    private final UniteService uniteService;

    @GetMapping
    public List<Unite.Unite> getAllUnite(){
        return uniteService.getAllUnite();
    }
    @GetMapping("/{id}")
    public Optional<Unite.Unite> getUniteById(@PathVariable long id){
        return uniteService.getUniteById(id);
    }
}
