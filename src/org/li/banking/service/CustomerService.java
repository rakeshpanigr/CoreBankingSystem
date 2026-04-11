package org.li.banking.service;

import java.util.Scanner;
import org.li.banking.model.Address;
import org.li.banking.model.Customer;
import org.li.banking.repository.CustomerRepository;

public class CustomerService{

    CustomerRepository customerRepository = new CustomerRepository();
    
    public void createCustomer(Scanner scanner){

        //taking customer inputs
        Customer c = new Customer();

        getCustomerInput(scanner, c);

        Integer idCounter = customerRepository.saveCustomer(c);

        System.out.println("Customer Created successfully with customer ID: " + idCounter);
    }

    public void viewCustomer(Scanner scanner){

        System.out.println("Enter customer ID:");
        Integer customerId = scanner.nextInt();

        Customer customer = customerRepository.viewCustomerById(customerId);

        getCustomerDetails(customer);

        Address a = customer.getAddress();
        getAddressDetails(a);


    }

    private static void getAddressDetails(Address a) {
        System.out.println("Address:");
        System.out.println("House No:" + a.getHouseNo());
        System.out.println("Building:" + a.getBuildingName());
        System.out.println("Street:" + a.getStreetName());
        System.out.println("City:" + a.getCity());
        System.out.println("District:" + a.getDistrict());
        System.out.println("State:" + a.getState());
        System.out.println("Pincode:" + a.getPincode());
    }

    private static void getCustomerDetails(Customer customer) {
        System.out.println("Customer Details:");
        System.out.println("ID:" + customer.getId());
        System.out.println("Name:" + customer.getName());
        System.out.println("Email:" + customer.getEmail());
        System.out.println("Phone:" + customer.getPhoneNo());
        System.out.println("PAN:" + customer.getPan());
    }

    private static void getCustomerInput(Scanner scanner, Customer c) {
        scanner.nextLine();
        System.out.println("Enter name:");
        c.setName(scanner.nextLine());

        System.out.println("Enter email:");
        c.setEmail(scanner.nextLine());

        System.out.println("Enter phone number:");
        c.setPhoneNo(scanner.nextLine());

        System.out.println("Enter pan:");
        c.setPan(scanner.nextLine());

        Address a = getAddress(scanner);
        c.setAddress(a);
    }

    private static Address getAddress(Scanner scanner) {
        //taking address inputs
        Address a = new Address();

        System.out.println("Enter house no:");
        a.setHouseNo(scanner.nextLine());

        System.out.println("Enter building name:");
        a.setBuildingName(scanner.nextLine());

        System.out.println("Enter street name:");
        a.setStreetName(scanner.nextLine());

        System.out.println("Enter city:");
        a.setCity(scanner.nextLine());

        System.out.println("Enter district:");
        a.setDistrict(scanner.nextLine());

        System.out.println("Enter state:");
        a.setState(scanner.nextLine());

        System.out.println("Enter pincode:");
        a.setPincode(scanner.nextInt());
        scanner.reset();
        return a;
    }


}