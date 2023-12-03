package com.Ecredit.demo.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/Customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer (){
        return customerService.getAllBankAccount();
    }
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(PathVariable id){
        return customerService.getBankAccountById(id);
    }
}
