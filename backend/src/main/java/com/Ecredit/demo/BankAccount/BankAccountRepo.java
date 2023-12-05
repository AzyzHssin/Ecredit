package com.Ecredit.demo.BankAccount;

import com.Ecredit.demo.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount,Long> {

}
