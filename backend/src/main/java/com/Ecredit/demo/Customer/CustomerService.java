package com.Ecredit.demo.Customer;

import com.Ecredit.demo.BankAccount.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById( long id ){
        return customerRepo.findById(id);
    }
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}
