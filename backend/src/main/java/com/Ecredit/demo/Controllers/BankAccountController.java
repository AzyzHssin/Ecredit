package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Models.BankAccount;
import com.Ecredit.demo.Service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/BankAccount")
@CrossOrigin(origins = "http://localhost:4200/")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAllBankAccount(){
        return bankAccountService.getAllBankAccount();
    }
    @GetMapping("/ByCustomer/{id}")

    public ResponseEntity<List<BankAccount>> getBankAccountByCustomerCin(@PathVariable long id){
        return ResponseEntity.ok(bankAccountService.getBankAccountByCustomerCin(id));
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
