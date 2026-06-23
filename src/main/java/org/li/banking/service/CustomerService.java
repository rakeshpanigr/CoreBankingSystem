package org.li.banking.service;

import org.li.banking.exception.CustomerNotFoundException;
import org.li.banking.model.Address;
import org.li.banking.model.Customer;
import org.li.banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE CUSTOMER
    public Customer createCustomer(Customer customer) {

        customer.getAddress().forEach(address ->
                address.setCustomer(customer));

        return customerRepository.save(customer);
    }

    // GET ALL CUSTOMERS
    public List<Customer> viewCustomer() {
        return customerRepository.findAll();
    }

    // GET CUSTOMER BY ID
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));
    }

    public void deleteCustomer(Integer id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found with id : " + id));

        customerRepository.delete(customer);
    }

    public Customer updateCustomer(Integer id, Customer customer) {

        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNo(customer.getPhoneNo());
        existingCustomer.setPan(customer.getPan());

        // Update Address if present
        if (customer.getAddress() != null) {
            for (Address address : customer.getAddress()) {

                // IMPORTANT
                address.setCustomer(existingCustomer);
            }

            existingCustomer.setAddress(customer.getAddress());
        }

        return customerRepository.save(existingCustomer);
    }
}