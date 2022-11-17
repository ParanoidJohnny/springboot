package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
