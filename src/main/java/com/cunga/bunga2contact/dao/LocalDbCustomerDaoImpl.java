package com.cunga.bunga2contact.dao;

import com.cunga.bunga2contact.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("CustomerLocalDB")
public class LocalDbCustomerDaoImpl implements CustomerDao{

    private static List<Customer> LOCALDB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){

        LOCALDB.add(new Customer(id,customer.getName()));
        return 1;
    }

}
