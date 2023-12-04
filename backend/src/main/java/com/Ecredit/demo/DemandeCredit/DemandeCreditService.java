package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.Customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemandeCreditService {
    private final DemandeCreditRepo demandeCreditRepo;

    public List<DemandeCredit> getAllDemandeCredit(){
        return demandeCreditRepo.findAll();
    }
    public Optional<DemandeCredit> getDemandeCreditById(long id ){
        return demandeCreditRepo.findById(id);
    }
    public DemandeCredit createDemandeCredit(DemandeCredit demandeCredit) {
        return demandeCreditRepo.save(demandeCredit);
    }
    public void deleteDemandeCredit(Long id) {
        demandeCreditRepo.deleteById(id);
    }
}
