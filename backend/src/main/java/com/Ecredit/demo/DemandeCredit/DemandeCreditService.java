package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.BankAccount.BankAccountRepo;
import com.Ecredit.demo.Customer.Customer;
import com.Ecredit.demo.Customer.CustomerRepo;
import com.Ecredit.demo.Files.File;
import com.Ecredit.demo.Files.FileRepo;
import com.Ecredit.demo.Guarantie.Guarantie;
import com.Ecredit.demo.Guarantie.GuarantieRepo;
import com.Ecredit.demo.TypeCredit.TypeCredit;
import com.Ecredit.demo.TypeCredit.TypeCreditRepo;
import com.Ecredit.demo.Unite.Unite;
import com.Ecredit.demo.Unite.UniteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemandeCreditService {

    private final DemandeCreditRepo demandeCreditRepo;
    private final CustomerRepo customerRepo;
    private final BankAccountRepo bankAccountRepo;
    private final UniteRepo uniteRepo;
    private final FileRepo fileRepo;
    private final GuarantieRepo guarantieRepo;
    private final TypeCreditRepo typeCreditRepo;
    public List<DemandeCredit> getAllDemandeCredit(){
        return demandeCreditRepo.findAll();
    }
    public Optional<DemandeCredit> getDemandeCreditById(long id ){
        return demandeCreditRepo.findById(id);
    }
    public DemandeCredit createDemandeCredit(DemandeCredit demandeCredit) {
        BankAccount  bankAccount= bankAccountRepo.findById(demandeCredit.getBankAccount().getId()).orElse(null);
        Guarantie guarantie=guarantieRepo.findById(demandeCredit.getGuarantie().getId()).orElse(null);
        TypeCredit typeCredit=typeCreditRepo.findById(demandeCredit.getTypeCredit().getId()).orElse(null);
        Unite unite=uniteRepo.findById(demandeCredit.getUnite().getId()).orElse(null);

        demandeCredit.setUnite(unite);
        bankAccount.getDemandeCredits().add(demandeCredit);
        //
        demandeCreditRepo.save(demandeCredit);
        //
        assert bankAccount != null;
        bankAccountRepo.save(bankAccount);
        assert guarantie != null;
        guarantieRepo.save(guarantie);
        assert typeCredit != null;
        typeCreditRepo.save(typeCredit);







//        customerRepo.save(customer);

        return demandeCredit;
    }
    public void deleteDemandeCredit(Long id) {
        demandeCreditRepo.deleteById(id);
    }
}
