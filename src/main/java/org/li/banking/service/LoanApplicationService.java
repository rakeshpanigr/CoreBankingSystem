package org.li.banking.service;

import org.li.banking.model.Customer;
import org.li.banking.model.LoanApplication;
import org.li.banking.repository.CustomerRepository;
import org.li.banking.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public LoanApplication createLoanApplication(
            LoanApplication loanApplication) {

        Integer customerId =
                loanApplication.getCustomer().getId();

        Customer customer =
                customerRepository.findById(customerId)
                        .orElseThrow(() ->
                                new RuntimeException("Customer not found"));

        loanApplication.setCustomer(customer);
        loanApplication.setStatus("SUBMITTED");
        loanApplication.setApplicationDate(LocalDate.now());

        return loanRepository.save(loanApplication);
    }

    public LoanApplication getLoanById(Long id) {

        return loanRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Loan not found"));
    }

    public List<LoanApplication> getAllLoans() {

        return loanRepository.findAll();
    }

    public List<LoanApplication> getLoansByCustomer(
            Integer customerId) {

        return loanRepository.findByCustomerId(customerId);
    }

    public LoanApplication updateStatus(
            Long id,
            String status) {

        LoanApplication loan =
                loanRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Loan not found"));

        loan.setStatus(status);

        return loanRepository.save(loan);
    }
}