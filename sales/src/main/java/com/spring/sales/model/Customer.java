package com.spring.sales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @Column(name="customer_id")
    private long customer_id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private long phone;
    @Column(name="address")
    private String address;
    @Column(name="communication_history")
    private String communication_history;
    @Column(name="purchase_history")
    private String purchase_history;
    @OneToMany(mappedBy = "customer_id")
    private List<Sale>sales;






}
