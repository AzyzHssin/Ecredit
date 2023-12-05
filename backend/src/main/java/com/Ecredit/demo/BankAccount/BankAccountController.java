package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/BankAccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAllBankAccount(){
        return bankAccountService.getAllBankAccount();
    }

    @GetMapping("/{id}")
    public Optional<BankAccount> getBankAccountById(@PathVariable long id){
        return bankAccountService.getBankAccountById(id);
    }
    @PostMapping("/add")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        System.out.println("BankAccount is created successefully");
        return bankAccountService.createBankAccount(bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable long id){
        bankAccountService.deleteBankAccount(id);
    }
}
