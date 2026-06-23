package com.ruggery.bank.controller;

import com.ruggery.bank.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;

    // Spring finds the @Service bean we tagged in Step 3 and injects it here
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/transfer")
    public String executeTransfer(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam double amount) {

        try {
            bankService.transfer(source, destination, amount);
            return "Transfer executed successfully!";
        } catch (Exception e) {
            return "Transfer failed: " + e.getMessage();
        }
    }
}