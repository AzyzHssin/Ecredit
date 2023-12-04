package com.Ecredit.demo.Customer;

import com.Ecredit.demo.DemandeCredit.DemandeCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/Customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> uniteList = customerService.getAllCustomer();
        return new ResponseEntity<>(uniteList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable long   id){
        return customerService.getCustomerById(id);
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
