package com.spring.sales.service;

import com.spring.sales.model.Customer;
//import com.spring.sales.model.Sale;
import com.spring.sales.repository.CustomerRepository;
//import com.spring.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> create(Customer customer){
        if(customerRepository.existsById(customer.getCustomer_id())){
            return  Optional.empty();
        }else {
            return Optional.of(customerRepository.save(customer));
        }
    }

    public List<Customer> retrieve(){
        return customerRepository.findAll();
    }

    public Optional<Customer> retrieveOne(long customer_id){
        return customerRepository.findById(customer_id);
    }

    public Optional<Customer> update(Customer customer){
        if(customerRepository.existsById(customer.getCustomer_id())){
            return Optional.of(customerRepository.save(customer));
        }else {
            return Optional.empty();
        }
    }



    public String delete(long customer_id){
        if(customerRepository.existsById(customer_id)){
            customerRepository.deleteById(customer_id);
            return customer_id+"deleted successfully!";
        }else{
            return"The sale data does not exist in record!";
        }
    }


}
