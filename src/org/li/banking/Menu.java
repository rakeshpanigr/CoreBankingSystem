package org.li.banking;
import java.util.Scanner;
import org.li.banking.model.Address;
import org.li.banking.model.Customer;
import org.li.banking.service.CustomerService;


public class Menu {
    CustomerService customer = new CustomerService();

    public void choice(){
        System.out.println("Enter your choice:\n" +
                            "1. Create Customer\n" +
                            "2. View Customer");

        Scanner scanner = new Scanner(System.in);
        int chosen = scanner.nextInt();
        scanner.reset();
        switch (chosen){
            case 1:
                customer.createCustomer(scanner);
                break;
            case 2:
                customer.viewCustomer(scanner);
                break;
            default:
                System.out.println("Please enter a valid choice");
                break;
        }

    }

}



