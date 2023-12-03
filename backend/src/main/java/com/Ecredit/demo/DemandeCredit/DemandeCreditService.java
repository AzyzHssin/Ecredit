package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.Customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemandeCreditService {
    private final DemandeCreditRepo demandeCreditRepo;

    public List<DemandeCredit> getAllBankAccount(){
        return demandeCreditRepo.findAll();
    }
    public Optional<DemandeCredit> getBankAccountById(long id ){
        return demandeCreditRepo.findById(id);
    }
}
