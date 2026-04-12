package org.li.banking.repository;

import org.li.banking.model.Customer;
import org.li.banking.model.Address;

import java.util.*;

public class CustomerRepository {

    private Map<Integer, Customer> custRepo = new HashMap<>();

    public Integer saveCustomer(Customer customer){

        Set<Integer> keySet =  custRepo.keySet();
        Integer custId = keySet.isEmpty()?0:Collections.max(keySet);
        custId = custId +1;
        customer.setId(custId);

        custRepo.put(custId,customer);
        return custId;
    }

    public Customer viewCustomerById(Integer Id){
        return custRepo.get(Id);
    }

}
