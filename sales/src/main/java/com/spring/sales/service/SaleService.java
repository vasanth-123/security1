package com.spring.sales.service;

import com.spring.sales.model.Sale;
import com.spring.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Optional<Sale>create(Sale sale){
        if(saleRepository.existsById(sale.getSale_id())){
            return  Optional.empty();
        }else {
            return Optional.of(saleRepository.save(sale));
        }
    }

    public List<Sale> retrieve(){
        return saleRepository.findAll();
    }

    public Optional<Sale> retrieveOne(long sale_id){
        return saleRepository.findById(sale_id);
    }

    public Optional<Sale> update(Sale sale){
        if(saleRepository.existsById(sale.getSale_id())){
            return Optional.of(saleRepository.save(sale));
        }else {
            return Optional.empty();
        }
    }



    public String delete(long saleid){
        if(saleRepository.existsById(saleid)){
            saleRepository.deleteById(saleid);
            return saleid+"deleted successfully!";
        }else{
            return"The sale data does not exist in record!";
        }
    }



}
