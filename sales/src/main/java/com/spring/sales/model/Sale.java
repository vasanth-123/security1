package com.spring.sales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "Sales")
public class Sale {
    @Id
    @Column(name = "sale_Id")
    private long sale_id;
    @Column(name = "name")
    private String name;
   @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    @ManyToOne
   private Customer customer_id;
    @Column(name = "opportunity_id")
    private int opportunity_id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "notes")
    private String notes;
/*
public Sale(){

}
    public Sale(int sale_id, String name, int customer_id, int opportunity_id, int amount, Date date, String notes) {
        this.sale_id = sale_id;
        this.name = name;
       this.customer_id = customer_id;
        this.opportunity_id = opportunity_id;
        this.amount = amount;
        this.date = date;
        this.notes = notes;
    }

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOpportunity_id() {
        return opportunity_id;
    }

    public void setOpportunity_id(int opportunity_id) {
        this.opportunity_id = opportunity_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }*/
}