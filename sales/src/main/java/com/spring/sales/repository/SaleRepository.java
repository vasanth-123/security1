package com.spring.sales.repository;

import com.spring.sales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
