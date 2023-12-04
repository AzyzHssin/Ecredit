package com.Ecredit.demo.Customer;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Customer> getCustomerById(@PathVariable long   id){
        return customerService.getBankAccountById(id);
    }
    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer) {
        System.out.println("Customer is created successefully");
        return customerService.createCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }
}
