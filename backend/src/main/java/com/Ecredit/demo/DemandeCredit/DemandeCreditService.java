package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.BankAccount.BankAccountRepo;
import com.Ecredit.demo.Customer.Customer;
import com.Ecredit.demo.Customer.CustomerRepo;
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

    public List<DemandeCredit> getAllDemandeCredit(){
        return demandeCreditRepo.findAll();
    }
    public Optional<DemandeCredit> getDemandeCreditById(long id ){
        return demandeCreditRepo.findById(id);
    }
    public DemandeCredit createDemandeCredit(DemandeCredit demandeCredit) {
        BankAccount  bankAccount= bankAccountRepo.findById(demandeCredit.getBankAccount().getId()).orElse(null);
//        Customer customer =customerRepo.findByCin(demandeCredit.getCustomer().getCin());
        Unite unite=uniteRepo.findById(demandeCredit.getUnite().getId()).orElse(null);
        demandeCredit.setUnite(unite);
        assert bankAccount != null;
        bankAccount.getDemandeCredits().add(demandeCredit);
        demandeCreditRepo.save(demandeCredit);
        bankAccountRepo.save(bankAccount);
//        customerRepo.save(customer);

        return demandeCredit;
    }
    public void deleteDemandeCredit(Long id) {
        demandeCreditRepo.deleteById(id);
    }
}
