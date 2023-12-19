package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount,Long> {
    List<BankAccount> findByCustomer_Cin(long cin);

}
