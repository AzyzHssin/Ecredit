package com.Ecredit.demo.BankAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/BankAccount")
public class BankAccountController {
    private final BankAccountRepo bankAccountRepo;

}
