package com.Ecredit.demo.Guarantie;


import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import com.Ecredit.demo.DemandeCredit.DemandeCreditRepo;
import com.Ecredit.demo.Devise.Devise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class GuarantieService {
    private final GuarantieRepo guarantieRepo;


    public List<Guarantie> getAllGuarantie (){
        return guarantieRepo.findAll();
    }

    public Optional<Guarantie> getGuarantieById(long id){
        return guarantieRepo.findById(id);
    }

    public long createGuarantie(Guarantie guarantie) {

        guarantieRepo.save(guarantie);
        return guarantie.getId();
    }
    public void deleteGuarantie(Long id) {
        guarantieRepo.deleteById(id);
    }
}
