package com.Ecredit.demo.NatureGuarantie;

import com.Ecredit.demo.Devise.Devise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
