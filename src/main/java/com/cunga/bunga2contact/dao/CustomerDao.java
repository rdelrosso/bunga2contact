package com.cunga.bunga2contact.dao;

import com.cunga.bunga2contact.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {

    int insertCustomer(UUID id, Customer customer);

    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }

    public List<Customer> selectAllPeople();

}
