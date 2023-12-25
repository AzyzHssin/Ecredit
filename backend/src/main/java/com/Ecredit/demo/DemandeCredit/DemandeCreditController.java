package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.BankAccount.BankAccountService;
import com.Ecredit.demo.Devise.Devise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/DemandeCredit")
@CrossOrigin(origins = "http://localhost:4200/")
public class DemandeCreditController {

    private final DemandeCreditService demandeCreditService;

    @GetMapping
    public List<DemandeCredit> getAllBankAccount(){
        return demandeCreditService.getAllDemandeCredit();
    }

    @GetMapping("/{id}")
    public Optional<DemandeCredit> getBankAccountById(@PathVariable long id){
        return demandeCreditService.getDemandeCreditById(id);
    }
    @PostMapping("/add")
    public DemandeCredit createDemandeCredit(@RequestBody DemandeCredit demandeCredit) {
        return demandeCreditService.createDemandeCredit(demandeCredit);
    }
    @PutMapping("/update")
    public DemandeCredit updateDemandeCredit(@RequestBody RequestUpdateBody updateRequest) {
        DemandeCredit demande = updateRequest.getDemande();
        String newEtat = updateRequest.getNouvelEtat();

        return demandeCreditService.updateDemandeCredit(demande,newEtat);
    }
    @DeleteMapping("/{id}")
    public void deleteDemandeCredit(@PathVariable long id){
        demandeCreditService.deleteDemandeCredit(id);
    }
}
