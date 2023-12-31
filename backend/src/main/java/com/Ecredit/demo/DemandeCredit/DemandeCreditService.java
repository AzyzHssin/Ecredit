package com.Ecredit.demo.DemandeCredit;

import com.Ecredit.demo.BankAccount.BankAccount;
import com.Ecredit.demo.BankAccount.BankAccountRepo;
import com.Ecredit.demo.Guarantie.Guarantie;
import com.Ecredit.demo.Guarantie.GuarantieRepo;
import com.Ecredit.demo.ScannedDocument.ScannedDocument;
import com.Ecredit.demo.ScannedDocument.ScannedDocumentRepository;
import com.Ecredit.demo.TypeCredit.TypeCredit;
import com.Ecredit.demo.TypeCredit.TypeCreditRepo;
import com.Ecredit.demo.Unite.Unite;
import com.Ecredit.demo.Unite.UniteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemandeCreditService {

    private final DemandeCreditRepo demandeCreditRepo;
    private final ScannedDocumentRepository scannedDocumentRepository;
    private final BankAccountRepo bankAccountRepo;
    private final GuarantieRepo guarantieRepo;
    private final UniteRepo uniteRepo;

    public List<DemandeCredit> getAllDemandeCredit(){
        return demandeCreditRepo.findAll();
    }
    public Optional<DemandeCredit> getDemandeCreditById(long id ){
        return demandeCreditRepo.findById(id);
    }
    public DemandeCredit createDemandeCredit(DemandeCredit demandeCredit) {
        demandeCredit.setDateDemande(new Date());
        demandeCredit.setEtat("En Cours");
        BankAccount  bankAccount= bankAccountRepo.findById(demandeCredit.getBankAccount().getId()).orElse(null);
        //
        Unite unite=uniteRepo.findById(demandeCredit.getUnite().getId()).orElse(null);
        demandeCredit.setUnite(unite);
        assert bankAccount != null;
        bankAccount.getDemandeCredits().add(demandeCredit);
        demandeCreditRepo.save(demandeCredit);
        bankAccountRepo.save(bankAccount);
        //////
        List<Guarantie> guarantieList=new ArrayList<>();
        for(Guarantie guarantie:demandeCredit.getGuaranties()){
            guarantieList.add(guarantieRepo.findById(guarantie.getId()).orElse(null));
        }
        demandeCredit.setGuaranties(guarantieList);
        demandeCredit.setScannedDocument(scannedDocumentRepository.findById(demandeCredit.getScannedDocument().getId()).orElse(null));

        return demandeCreditRepo.save(demandeCredit);
    }
    public DemandeCredit updateDemandeCredit(DemandeCredit frontDemandeCredit ,String newEtat){
        Optional<DemandeCredit> backDemandCredit= this.getDemandeCreditById(frontDemandeCredit.getId());
        if(backDemandCredit.isPresent()){
            DemandeCredit existingDemandeCredit = backDemandCredit.get();
            existingDemandeCredit.setEtat(newEtat);
            return demandeCreditRepo.save(existingDemandeCredit);
        }
        return null;
    }
    public void deleteDemandeCredit(Long id) {
        demandeCreditRepo.deleteById(id);
    }
}
