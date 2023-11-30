package com.Ecredit.demo.Guarantie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public Optional<Guarantie> getGuarantieById(@PathVariable long id){return guarantieService.getGuarantieById(id);}
}
