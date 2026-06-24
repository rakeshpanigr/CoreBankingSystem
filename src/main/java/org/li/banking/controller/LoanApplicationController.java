package org.li.banking.controller;

import org.li.banking.model.LoanApplication;
import org.li.banking.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanService;

    @PostMapping
    public LoanApplication createLoanApplication(
            @RequestBody LoanApplication loanApplication) {

        return loanService.createLoanApplication(
                loanApplication);
    }

    @GetMapping("/{id}")
    public LoanApplication getLoanById(
            @PathVariable Long id) {

        return loanService.getLoanById(id);
    }

    @GetMapping
    public List<LoanApplication> getAllLoans() {

        return loanService.getAllLoans();
    }

    @GetMapping("/customer/{customerId}")
    public List<LoanApplication> getLoansByCustomer(
            @PathVariable Integer customerId) {

        return loanService.getLoansByCustomer(customerId);
    }

    @PutMapping("/{id}/status")
    public LoanApplication updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return loanService.updateStatus(id, status);
    }
}