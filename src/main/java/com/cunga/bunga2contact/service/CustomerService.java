package com.cunga.bunga2contact.service;

import com.cunga.bunga2contact.dao.CustomerDao;
import com.cunga.bunga2contact.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerLocalDB") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers(){
       return customerDao.selectAllPeople();
    }

    public Optional<Customer> getCustomerById(UUID id){
        return customerDao.selectCustomerById(id);
    }

    public int deleteCustomerByID(UUID id){
        return customerDao.deleteCustomerByID(id);
    }

    public int updateCustomerByID(UUID id, Customer customer){
        return customerDao.updateCustomerByID(id, customer);
    }
}
