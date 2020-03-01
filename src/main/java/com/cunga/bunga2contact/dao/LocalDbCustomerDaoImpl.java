package com.cunga.bunga2contact.dao;

import com.cunga.bunga2contact.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("CustomerLocalDB")
public class LocalDbCustomerDaoImpl implements CustomerDao{

    private static List<Customer> LOCALDB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){

        LOCALDB.add(new Customer(id,
                customer.getName(),
                customer.getSurname(),
                customer.getDateOfBirth(),
                customer.getAddressLine1(),
                customer.getAddressLine2(),
                customer.getCity(),
                customer.getState(),
                customer.getPostCode(),
                customer.getEmailAddress(),
                customer.getPhoneNumber()));
        return 1;
    }

    @Override
    public List<Customer> selectAllPeople() {
        return LOCALDB;
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return LOCALDB.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCustomerByID(UUID id) {
        Optional<Customer> customerOptional = selectCustomerById(id);
        if (customerOptional.isPresent()){
            LOCALDB.remove(customerOptional.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCustomerByID(UUID id, Customer customer) {
        return selectCustomerById(id)
                .map(customer1 -> {
                    int indexOfCustomerToDelete = LOCALDB.indexOf(customer1);
                    if (indexOfCustomerToDelete >= 0) {
                        LOCALDB.set(indexOfCustomerToDelete, new Customer(
                                id,
                                customer.getName(),
                                customer.getSurname(),
                                customer.getDateOfBirth(),
                                customer.getAddressLine1(),
                                customer.getAddressLine2(),
                                customer.getCity(),
                                customer.getState(),
                                customer.getPostCode(),
                                customer.getEmailAddress(),
                                customer.getPhoneNumber())
                        );
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }


}
