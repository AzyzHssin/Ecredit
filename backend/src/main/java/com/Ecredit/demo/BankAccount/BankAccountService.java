package com.Ecredit.demo.BankAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepo bankAccountRepo;

    public List<BankAccount> getAllBankAccount(){
        return bankAccountRepo.findAll();
    }
    public Optional<BankAccount> getBankAccountById(long id ){
        return bankAccountRepo.findById(id);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepo.save(bankAccount);
    }
    public void deleteBankAccount(Long id) {
        bankAccountRepo.deleteById(id);
    }
}
