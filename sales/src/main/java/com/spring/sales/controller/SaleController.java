package com.spring.sales.controller;

import com.spring.sales.model.Sale;
import com.spring.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public String saveSale(@RequestBody Sale sale) {
        Optional<Sale>_sale= saleService.create(sale);
        if (_sale.isPresent()){
            return "The sale data has been saved successfully!";
        }else {
            return"sale already exist in record";
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable("id")int id){
        Optional<Sale> sale=saleService.retrieveOne(id);
        if (sale.isPresent()){
            return new ResponseEntity<>(sale.get(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    public List<Sale> getALLSale(){
        return saleService.retrieve();
    }
    @PutMapping
    public String update(@RequestBody Sale sale){
        Optional<Sale>_sale=saleService.update(sale);
        if (_sale.isEmpty()){
            return"the sale data data does not exist in record!";

        }else {
            return "the sale data has been updated successfully!";
        }
    }
@DeleteMapping("/{id}")
    public String deleteSaleById(@PathVariable("id") int id){
        return saleService.delete(id);
    }


}
