package com.Ecredit.demo.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public List<Customer> getAllBankAccount(){
        return customerRepo.findAll();
    }
    public Optional<Customer> getBankAccountById(PathVariable id ){
        return customerRepo.findById(id);
    }
}
