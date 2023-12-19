package com.Ecredit.demo.Guarantie;

import com.Ecredit.demo.NatureGuarantie.NatureGuarantie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/Guarantie")
public class GuarantieController {
private final GuarantieService guarantieService;

@GetMapping
public List<Guarantie> getAllGuarantie() {
    return guarantieService.getAllGuarantie();}
    @GetMapping("/{id}")
public Optional<Guarantie> getGuarantieById(@PathVariable long id)
    {
        return guarantieService.getGuarantieById(id);
    }
    @PostMapping("/add")
    public long createGuarantie(@RequestBody Guarantie guarantie) {
        System.out.println("Guarantie is created successefully");
        return guarantieService.createGuarantie(guarantie);
    }
    @DeleteMapping("/{id}")
    public void deleteGuarantie(@PathVariable long id){
        guarantieService.deleteGuarantie(id);
    }


}
