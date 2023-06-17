package com.spring.sales.controller;

import com.spring.sales.model.Customer;
import com.spring.sales.model.Sale;
import com.spring.sales.service.CustomerService;
import com.spring.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String saveCustomer(@RequestBody Customer customer) {
        Optional<Customer> _customer= customerService.create(customer);
        if (_customer.isPresent()){
            return "The sale data has been saved successfully!";
        }else {
            return"sale already exist in record";
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id")int id){
        Optional<Customer> customer=customerService.retrieveOne(id);
        if (customer.isPresent()){
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    public List<Customer> getALLSale(){
        return customerService.retrieve();
    }
    @PutMapping
    public String update(@RequestBody Customer customer){
        Optional<Customer>_customer=customerService.update(customer);
        if (_customer.isEmpty()){
            return"the sale data data does not exist in record!";

        }else {
            return "the sale data has been updated successfully!";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable("id") int id){
        return customerService.delete(id);
    }






}
