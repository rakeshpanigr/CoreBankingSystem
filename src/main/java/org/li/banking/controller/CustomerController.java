package org.li.banking.controller;

import org.li.banking.model.Customer;
import org.li.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE CUSTOMER
    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerService.viewCustomer();
    }

    // GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(
            @PathVariable Integer id) {

        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(
            @PathVariable Integer id) {

        customerService.deleteCustomer(id);
        return "Deleted";
    }

    // UPDATE CUSTOMER
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Integer id,
            @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }
}