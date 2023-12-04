package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import com.Ecredit.demo.Customer.CustomerRepo;
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
