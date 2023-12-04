package com.Ecredit.demo.Unite;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/Unite")
public class UniteController {
    private final UniteService uniteService;

    @GetMapping
    public List<Unite> getAllUnite(){
        return uniteService.getAllUnite();
    }
    @GetMapping("/{id}")
    public Optional<Unite> getUniteById(@PathVariable long id){
        return uniteService.getUniteById(id);
    }
    @PostMapping("/add")
    public Unite createUnite(@RequestBody Unite unite) {
        System.out.println("unite is created successefully");
        return uniteService.createUnite(unite);
    }
    @DeleteMapping("/{id}")
    public void deleteUnite(@PathVariable long id){
         uniteService.deleteUnite(id);
    }

}
