package com.cunga.bunga2contact.api;

import com.cunga.bunga2contact.model.Customer;
import com.cunga.bunga2contact.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/b2contact/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public void addCustomer(@Valid @NonNull @RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id){
        return customerService.getCustomerById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id){
        customerService.deleteCustomerByID(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomerById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Customer customer){
        customerService.updateCustomerByID(id, customer);
    }
}
