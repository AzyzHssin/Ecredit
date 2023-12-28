package com.Ecredit.demo.NatureGuarantie;

import com.Ecredit.demo.Models.NatureGuarantie;
import com.Ecredit.demo.Service.NatureGuarantieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/NatureGuarantie")
public class NatureGuarantieController {
    private final NatureGuarantieService natureGuarantieService;

    @GetMapping

    public List<NatureGuarantie> getAllNatureGuarantie(){
        return natureGuarantieService.getAllNatureGuarantie();
    }

    @GetMapping("/{id}")
    public Optional <NatureGuarantie> getNatureGuarantieByid(@PathVariable long id){
        return natureGuarantieService.getNatureGuarantieById(id);
    }
    @PostMapping("/add")
    public NatureGuarantie createNatureGuarantie(@RequestBody NatureGuarantie natureGuarantie) {
        System.out.println("NatureGuarantie is created successefully");
        return natureGuarantieService.createNatureGuarantie(natureGuarantie);
    }
    @DeleteMapping("/{id}")
    public void deleteNatureGuarantie(@PathVariable long id){
        natureGuarantieService.deleteNatureGuarantie(id);
    }
}
