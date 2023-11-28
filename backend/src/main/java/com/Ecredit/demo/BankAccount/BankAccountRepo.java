package com.Ecredit.demo.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount,Long> {
}
