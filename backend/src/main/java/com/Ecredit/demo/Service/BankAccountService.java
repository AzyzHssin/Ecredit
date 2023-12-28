package com.Ecredit.demo.Service;

import com.Ecredit.demo.Repositories.BankAccountRepo;
import com.Ecredit.demo.Models.Customer;
import com.Ecredit.demo.Repositories.CustomerRepo;
import com.Ecredit.demo.Models.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepo bankAccountRepo;
    private final CustomerRepo customerRepo;

    public List<BankAccount> getAllBankAccount(){
        return bankAccountRepo.findAll();
    }
    public List<BankAccount> getBankAccountByCustomerCin(long id){
        return bankAccountRepo.findByCustomer_Cin(id);
    }
    public Optional<BankAccount> getBankAccountById(long id ){
        return bankAccountRepo.findById(id);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        Customer customer= customerRepo.findByCin(bankAccount.getCustomer().getCin());
        customer.getListOfAccounts().add(bankAccount);
        bankAccountRepo.save(bankAccount);
        customerRepo.save(customer);
        return bankAccount;
    }
    public void deleteBankAccount(Long id) {
        bankAccountRepo.deleteById(id);
    }
}
